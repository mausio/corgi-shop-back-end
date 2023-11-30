package com.pembroke.corgishopappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pembroke.corgishopappbackend.dto.CategoryDTO;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.entity.Category;
import com.pembroke.corgishopappbackend.entity.Item;
import com.pembroke.corgishopappbackend.service.CategoryService;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //TODO: Delete this method when using a final Database
    @GetMapping("/saveCategories")
    public ResponseEntity<Void> saveCategoriesInLocalDatabase() {
        List<Item> items1 = Arrays.asList(
                new Item("PulloverItem1", 0, false, "Pullover Item1 Image Url", null),
                new Item("PulloverItem2", 0, false, "Pullover Item2 Image Url", null)
        );
        List<Item> items2 = Arrays.asList(
                new Item("PillowItem1", 0, false, "Pillow Item1 Image Url", null),
                new Item("PillowItem2", 0, false, "Pillow Item2 Image Url", null)
        );
        List<Item> items3 = Arrays.asList(
                new Item("MugItem1", 0, false, "Mug Item1 Image Url", null),
                new Item("MugItem2", 0, false, "Mug Item2 Image Url", null)
        );

        Category category1 = new Category("Pullover", "Pullover Image Url", items1);
        Category category2 = new Category("Pillow", "Pillow Image Url", items2);
        Category category3 = new Category("Mug", "Mug Image Url", items3);

        for (Item value : items1) {
            value.setCategory(category1);
        }

        for (Item value : items2) {
            value.setCategory(category2);
        }

        for (Item value : items3) {
            value.setCategory(category3);
        }

        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("categories/{name}/items")
    public ResponseEntity<List<ItemDTO>> getItemsByCategoryName(@PathVariable String name) {
        List<ItemDTO> items = categoryService.getAllItemsFromCategory(name);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
