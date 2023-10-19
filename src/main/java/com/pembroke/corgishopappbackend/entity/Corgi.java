package com.pembroke.corgishopappbackend.entity;

import java.util.Date;

public class Corgi {

    private int id;
    private String name;
    private int price;
    private boolean isFavorite;
    private String description;
    private String imageUrl;

    private Date birthdate;
    private String coatColor;
    private int weight;
    private int height;
    private boolean isMale;

    public Corgi() {}

    //Remove id from constructor when using it in database
    public Corgi(int id, String name, int price, boolean isFavorite, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isFavorite = isFavorite;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    //Remove id from constructor when using it in database
    public Corgi(int id, String name, int price, boolean isFavorite, String description, String imageUrl, Date birthdate, String coatColor, int weight, int height, boolean isMale) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isFavorite = isFavorite;
        this.description = description;
        this.imageUrl = imageUrl;
        this.birthdate = birthdate;
        this.coatColor = coatColor;
        this.weight = weight;
        this.height = height;
        this.isMale = isMale;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Corgi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isFavorite=" + isFavorite +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", birthdate=" + birthdate +
                ", coatColor='" + coatColor + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", isMale=" + isMale +
                '}';
    }
}
