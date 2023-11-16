package com.pembroke.corgishopappbackend.dto;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private String imageUrl;
    private List<ItemDTO> items;

    public CategoryDTO() {}

    public CategoryDTO(String name, String imageUrl, List<ItemDTO> items) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", items=" + items +
                '}';
    }
}
