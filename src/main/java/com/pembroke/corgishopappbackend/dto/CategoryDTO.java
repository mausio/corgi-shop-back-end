package com.pembroke.corgishopappbackend.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private String imageUrl;
    private List<ItemDTO> items = new ArrayList<>();

    public CategoryDTO() {}

    public CategoryDTO(String name, String imageUrl,List<ItemDTO> items, int price, String categoryName, boolean isFavorite, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.items = items;
        
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", items='" + items + '\'' + 
                '}';
            
    }
}
