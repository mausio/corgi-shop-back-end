package com.pembroke.corgishopappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pembroke.corgishopappbackend.dto.CategoryDTO;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.entity.Category;
import com.pembroke.corgishopappbackend.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/saveCategories")
    public ResponseEntity<Void> saveCategoriesInLocalDatabase() {
        Category category1 = new Category("Pullover", "Pullover Image Url", null);
        Category category2 = new Category("Pillow", "Pillow Image Url", null);
        Category category3 = new Category("Mug", "Mug Image Url", null);

        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{name}/items")
    public ResponseEntity<List<ItemDTO>> getItemsByCategoryName(@PathVariable String name) {
        List<ItemDTO> items = categoryService.getAllItemsFromCategory(name);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
