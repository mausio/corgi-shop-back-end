package com.pembroke.corgishopappbackend.dto;

public class ItemDTO {

    private int id;
    private String name;
    private int price;
    private boolean isFavorite;
    private String description;
    private String imageUrl;

    public ItemDTO() {}

    public ItemDTO(String name, int price, boolean isFavorite, String description, String imageUrl) {
        this.name = name;
        this.price = price;
        this.isFavorite = isFavorite;
        this.description = description;
        this.imageUrl = imageUrl;
    }
    
    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isFavorite=" + isFavorite +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
