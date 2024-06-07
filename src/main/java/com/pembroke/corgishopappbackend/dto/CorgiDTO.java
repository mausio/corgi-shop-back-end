package com.pembroke.corgishopappbackend.dto;

public class CorgiDTO {

    private int id;
    private String uuid;
    private String name;
    private int price;
    private String description;
    private String imageUrl;
    private String birthdate;
    private String coatColor;
    private int weight;
    private int height;
    private boolean isMale;

    public CorgiDTO() {}

    public CorgiDTO(String name, int price, String description, String imageUrl, String birthdate, String coatColor, int weight, int height, boolean isMale, String uuid) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.birthdate = birthdate;
        this.coatColor = coatColor;
        this.weight = weight;
        this.height = height;
        this.isMale = isMale;
        this.uuid = uuid;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "CorgiDTO{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", coatColor='" + coatColor + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", isMale=" + isMale +
                '}';
    }
}
