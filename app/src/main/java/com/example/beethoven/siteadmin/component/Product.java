package com.example.beethoven.siteadmin.component;

import java.io.Serializable;

/**
 * Created by beethoven on 14.07.2017.
 */

public class Product implements Serializable {
    private int id;
    private String nameProduct;
    private String typeProduct;
    private String content;
    private String titleImage;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private int price;
    private String availability;
    private int countP;

    public Product(int id, String nameProduct, String typeProduct, String content, String titleImage, String image1, String image2, String image3, String image4, int price, String availability, int countP) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
        this.content = content;
        this.titleImage = titleImage;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.price = price;
        this.availability = availability;
        this.countP = countP;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getCountP() {
        return countP;
    }

    public void setCountP(int countP) {
        this.countP = countP;
    }

    @Override
    public String toString() {
        return getNameProduct();
    }
}
