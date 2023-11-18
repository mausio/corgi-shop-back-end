package com.pembroke.corgishopappbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "is_favorite")
    private boolean isFavorite;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    public Item() {}

    public Item(String name, int price, Category category, boolean isFavorite, String description, String imageUrl) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.isFavorite = isFavorite;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Other methods...

    public void setCategory(Category category) {
        this.category = category;
    }

    // Other methods...
}
