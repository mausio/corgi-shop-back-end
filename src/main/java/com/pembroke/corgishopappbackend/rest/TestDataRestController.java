package com.pembroke.corgishopappbackend.rest;

import com.pembroke.corgishopappbackend.dao.*;
import com.pembroke.corgishopappbackend.entity.*;
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
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CorgiRepository corgiRepository;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TestDataRestController(CorgiService corgiService, CategoryService categoryService, UserRepository userRepository, CartRepository cartRepository, CorgiRepository corgiRepository, CorgiRepository corgiRepository1, ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.corgiService = corgiService;
        this.categoryService = categoryService;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.corgiRepository = corgiRepository1;
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/test-data")
    public ResponseEntity<String> addTestDataCorgis() {

        Corgi corgi1 = new Corgi("Robin", 1, "Robin is a friendly and playful Corgi.", "https://www.akc.org/wp-content/uploads/2017/11/Pembroke-Welsh-Corgi-standing-outdoors-in-the-fall-400x267.jpg", new Date(2018-1900, 4, 15), "red and white", 13, 28, true);
        Corgi corgi2 = new Corgi("Mael", 2, "Mael loves to play fetch and is very energetic.", "https://www.zooplus.de/magazin/wp-content/uploads/2017/07/Welsh-Corgi-Pembroke-sitzt-in-der-Natur-1024x682.jpeg", new Date(2019-1900, 6, 20), "fawn", 12, 27, true);
        Corgi corgi3 = new Corgi("Lily", 3, "Lily is a gentle and affectionate Corgi.", "https://www.purina.de/sites/default/files/styles/ttt_image_510/public/2021-01/Welsh%20Corgi%20%28Pembroke%291.jpg?itok=-ALFB8xn", new Date(2020-1900, 9, 5), "sable", 11, 25, false);
        Corgi corgi4 = new Corgi("Luna", 4, "Luna enjoys long walks and cuddles.", "https://www.tierchenwelt.de/images/stories/haustiere/hunde/welsh_corgi_hunderasse_l.jpg", new Date(2017-1900, 3, 12), "black and white", 13, 28, true);
        Corgi corgi5 = new Corgi("Luca", 5, "Luca is a playful and curious Corgi.", "https://www.hundeo.com/wp-content/uploads/2019/04/Welsh-Corgi-Pembroke-glu%CC%88cklich.jpg", new Date(2016-1900, 11, 25), "red", 12, 26, true);
        Corgi corgi6 = new Corgi("Luna", 6, "Luna is a sweet and loyal companion.", "https://tse2.mm.bing.net/th?id=OIP.YxuvT-6i10pawo2m3OZ8CwHaLE&pid=Api", new Date(2021-1900, 1, 30), "white and tan", 10, 24, false);
        Corgi corgi7 = new Corgi("Lia", 7, "Lia is full of energy and loves to play.", "https://tse4.mm.bing.net/th?id=OIP.SfyfeXpvTHc-2OY1Q9x7ogAAAA&pid=Api", new Date(2018-1900, 7, 14), "red and white", 11, 25, false);
        Corgi corgi8 = new Corgi("Niklas", 8, "Niklas is a brave and adventurous Corgi.", "https://tse3.mm.bing.net/th?id=OIP.FAc0qMNYY9SUI8Wq0O53kAHaJ4&pid=Api", new Date(2022-1900, 5, 8), "white and sable", 12, 27, true);
        Corgi corgi9 = new Corgi("Tobi", 9, "Tobi is a calm and friendly Corgi.", "https://tse3.mm.bing.net/th?id=OIP.HhAOcJfhKuZI_4GM4EMyhQHaFd&pid=Api", new Date(2019-1900, 8, 22), "red and white", 13, 28, true);

        corgiService.save(corgi1);
        corgiService.save(corgi2);
        corgiService.save(corgi3);
        corgiService.save(corgi4);
        corgiService.save(corgi5);
        corgiService.save(corgi6);
        corgiService.save(corgi7);
        corgiService.save(corgi8);
        corgiService.save(corgi9);

        List<Item> items1 = Arrays.asList(
                new Item("CozyRedPullover", 30, false, "Cozy red wool pullover", "https://i.pinimg.com/originals/45/cd/58/45cd581d8e8654c7abbb592c3b683bf5.jpg"),
                new Item("StylishBluePullover", 40, false, "Stylish blue cotton pullover", "https://images-na.ssl-images-amazon.com/images/I/81atEmI70OL._AC_UX569_.jpg"),
                new Item("WarmGreenPullover", 50, false, "Warm green fleece pullover", "https://i.pinimg.com/736x/b6/6e/df/b66edf63c20145abdb7f35126f8891ee--summer-clothing-corgis.jpg"),
                new Item("ElegantBlackPullover", 60, false, "Elegant black cashmere pullover", "https://m.media-amazon.com/images/I/B1i3u9-Q-KS._CLa%7C2140%2C2000%7CB1mK8La4CwS.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_AC_UL1500_.png")
        );

        List<Item> items2 = Arrays.asList(
                new Item("SoftWhitePillow", 10, false, "Soft white down pillow", "https://i.etsystatic.com/20467091/r/il/fe2d7e/1913977052/il_794xN.1913977052_j4u2.jpg"),
                new Item("FirmMemoryFoamPillow", 20, false, "Firm memory foam pillow", "https://i.pinimg.com/originals/9e/59/18/9e5918a73a9008878e8df5c0ee5d5722.jpg"),
                new Item("ComfortableBambooPillow", 30, false, "Comfortable bamboo pillow", "https://cdn.shopify.com/s/files/1/0510/0516/1665/products/product-image-1567739310_1024x1024.jpg?v=1605017576"),
                new Item("LuxuriousSilkPillow", 40, false, "Luxurious silk pillow", "https://i.pinimg.com/originals/14/4c/72/144c727f0711edc382b9393e008ad63a.jpg")
        );

        List<Item> items3 = Arrays.asList(
                new Item("ClassicWhiteMug", 70, false, "Classic white ceramic mug", "https://i.pinimg.com/originals/12/33/39/12333992ed450702ccb462c7e27f3b68.png"),
                new Item("ColorfulPatternedMug", 80, false, "Colorful patterned mug", "https://i.pinimg.com/originals/f9/ab/a3/f9aba3fac13c85915b0312146eb29164.jpg"),
                new Item("ElegantBlackMug", 90, false, "Elegant black porcelain mug", "https://www.pinterest.com/pin/501447739754402352/"),
                new Item("ModernSteelMug", 100, false, "Modern stainless steel mug", "https://secure.img1-fg.wfcdn.com/im/05899125/resize-h600-w600%5Ecompr-r85/1093/109326384/Pembroke+Welsh+Corgi+Dog+Double+Wall+Stainless+Steel+Travel+Tumbler.jpg")
        );



        Category category1 = new Category("Pullover", "https://i.pinimg.com/originals/45/cd/58/45cd581d8e8654c7abbb592c3b683bf5.jpg", items1);
        Category category2 = new Category("Pillow", "https://i.pinimg.com/originals/14/4c/72/144c727f0711edc382b9393e008ad63a.jpg", items2);
        Category category3 = new Category("Mug", "", items3);

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

        List<Corgi> corgis = Arrays.asList(corgi1, corgi2, corgi3);
        List<Item> items = Arrays.asList(items1.get(0), items2.get(0), items3.get(0));
        Cart cart = new Cart(corgis, items);

        for (Corgi value : corgis) {
            value.setCart(cart);
        }

        for (Item value : items) {
            value.setCart(cart);
        }

        cartRepository.save(cart);

        userRepository.save(new User("user", "$2y$10$4U8NfYDeUt83qg9BhyJ12Oq6EaCjMwnZDM2L.kdnr09vCtqxQzMxG", cart));

        return ResponseEntity.ok("Test data added");
    }

    @GetMapping("/delete-all")
    public ResponseEntity<String> deleteAllData() {
    userRepository.deleteAll();
    cartRepository.deleteAll();
    corgiRepository.deleteAll();
    categoryRepository.deleteAll();
    itemRepository.deleteAll();
    return ResponseEntity.ok("All data deleted");
}

}
