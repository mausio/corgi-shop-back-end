package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.entity.Category;
import com.pembroke.corgishopappbackend.entity.Corgi;
import com.pembroke.corgishopappbackend.entity.Item;
import com.pembroke.corgishopappbackend.service.CategoryService;
import com.pembroke.corgishopappbackend.service.CorgiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TestDataRestController {

    private final CorgiService corgiService;
    private final CategoryService categoryService;

    @Autowired
    public TestDataRestController(CorgiService corgiService, CategoryService categoryService) {
        this.corgiService = corgiService;
        this.categoryService = categoryService;
    }

    @GetMapping("/test-data/corgis")
    public ResponseEntity<String> addTestDataCorgis() {

        Corgi corgi1 = new Corgi("Robin", 100, "Robin is dog", "https://www.akc.org/wp-content/uploads/2017/11/Pembroke-Welsh-Corgi-standing-outdoors-in-the-fall-400x267.jpg", new Date(), "white", 80, 190, true);
        Corgi corgi2 = new Corgi("Mael", 200, "Mael is dog", "https://www.zooplus.de/magazin/wp-content/uploads/2017/07/Welsh-Corgi-Pembroke-sitzt-in-der-Natur-1024x682.jpeg", new Date(), "chocolate", 80, 190, true);
        Corgi corgi3 = new Corgi("Lily", 300, "Lily is dog", "https://www.purina.de/sites/default/files/styles/ttt_image_510/public/2021-01/Welsh%20Corgi%20%28Pembroke%291.jpg?itok=-ALFB8xn", new Date(), "brown", 100, 200, false);
        Corgi corgi4 = new Corgi("Luna", 400, "Loa is dog", "https://www.tierchenwelt.de/images/stories/haustiere/hunde/welsh_corgi_hunderasse_l.jpg", new Date(), "notWhite", 10, 10, false);
        Corgi corgi5 = new Corgi("Luca", 50000000, "Luca is dog", "https://www.hundeo.com/wp-content/uploads/2019/04/Welsh-Corgi-Pembroke-glu%CC%88cklich.jpg", new Date(), "pink", 999999, 99999999, true);
        Corgi corgi6 = new Corgi("Luna", 600, "Luna is dog", "https://tse2.mm.bing.net/th?id=OIP.YxuvT-6i10pawo2m3OZ8CwHaLE&pid=Api", new Date(), "white", 30, 180, false);
        Corgi corgi7 = new Corgi("Lia", 700, "Lia is dog", "https://tse4.mm.bing.net/th?id=OIP.SfyfeXpvTHc-2OY1Q9x7ogAAAA&pid=Api", new Date(), "orange", 40, 135, false);
        Corgi corgi8 = new Corgi("Niklas", 800, "Niklas is dog", "https://tse3.mm.bing.net/th?id=OIP.FAc0qMNYY9SUI8Wq0O53kAHaJ4&pid=Api", new Date(), "white", 65, 175, true);
        Corgi corgi9 = new Corgi("Tobi", 900, "Tobi is dog", "https://tse3.mm.bing.net/th?id=OIP.HhAOcJfhKuZI_4GM4EMyhQHaFd&pid=Api", new Date(), "white", 75, 175, true);

        corgiService.save(corgi1);
        corgiService.save(corgi2);
        corgiService.save(corgi3);
        corgiService.save(corgi4);
        corgiService.save(corgi5);
        corgiService.save(corgi6);
        corgiService.save(corgi7);
        corgiService.save(corgi8);
        corgiService.save(corgi9);

        return ResponseEntity.ok("Test corgi data added");
    }

    @GetMapping("/test-data/categories")
    public ResponseEntity<String> addTestDataCategories() {

        List<Item> items1 = Arrays.asList(
                new Item("PulloverItem1", 30, false, "Pullover Item1 Image Url", null),
                new Item("PulloverItem2", 40, false, "Pullover Item2 Image Url", null),
                new Item("PulloverItem3", 50, false, "Pullover Item3 Image Url", null),
                new Item("PulloverItem4", 60, false, "Pullover Item2 Image Url", null)
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

        return ResponseEntity.ok("Test category data added");
    }

}
