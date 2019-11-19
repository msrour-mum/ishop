package edu.mum.ishop.model;

public class Product {
    private int id ;
    private String productName ;
    private String description ;
    private String seller ;
    private float price ;
    private boolean isActive ;
    private String imageUrl ;


    public Product(int id, String productName, String description, String seller, float price, boolean isActive, String imageUrl) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.seller = seller;
        this.price = price;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
