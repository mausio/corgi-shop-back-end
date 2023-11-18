package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.CategoryDTO;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.service.CategoryService;
import com.pembroke.corgishopappbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    private final CategoryService categoryService;
    private final ItemService itemService;

    @Autowired
    public CategoryRestController(CategoryService categoryService, ItemService itemService) {
        this.categoryService = categoryService;
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> exampleCategories = List.of(
                new CategoryDTO("Category1", "imageUrl1"),
                new CategoryDTO("Category2", "imageUrl2"),
                new CategoryDTO("Category3", "imageUrl3")
        );

        return ResponseEntity.status(HttpStatus.OK).body(exampleCategories);
    }

    @GetMapping("/{name}/items")
    public ResponseEntity<List<ItemDTO>> getItemsByCategoryName(@PathVariable String name) {
        List<ItemDTO> items = itemService.findByCategoryName(name);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
}
