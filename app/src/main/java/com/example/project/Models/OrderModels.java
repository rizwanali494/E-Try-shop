package com.example.project.Models;

public class OrderModels {
    int orderImage;
    String soldItemName, price, ordeNumber;

    public OrderModels() {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.ordeNumber = ordeNumber;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdeNumber() {
        return ordeNumber;
    }

    public void setOrdeNumber(String ordeNumber) {
        this.ordeNumber = ordeNumber;
    }
}
