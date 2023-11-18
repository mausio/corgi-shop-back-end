package com.pembroke.corgishopappbackend.dto;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private String imageUrl;

    public CategoryDTO() {}

    public CategoryDTO(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
