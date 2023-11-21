package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dto.CategoryDTO;
import com.pembroke.corgishopappbackend.dto.ItemDTO;
import com.pembroke.corgishopappbackend.entity.Category;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.service.CategoryService;
import com.pembroke.corgishopappbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

   
    @GetMapping("/saveCategries")
    public ResponseEntity saveCategoriesInLocalDatabase() {

        Item item1 = new Item("Blackpullover", 100, "Robin is dog", "", new Date(), "white", 80, 190, true);

        Category category1 = new Category("Pullover", "");
        Category category2 = new Category("Pillow", "Image Url");
        Category category3 = new Category("Mug", "Image Url");
        //items schreiben, der liste hinzufuegen , liste den categorien hinzufuegen (uber den konstruktor und dann saven) 

        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);


        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/{name}/items")
    public ResponseEntity<List<ItemDTO>> getItemsByCategoryName(@PathVariable String name) {
        List<ItemDTO> items = itemService.findByCategoryName(name);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
}
