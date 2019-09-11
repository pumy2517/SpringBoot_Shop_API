package com.example.SmartShop;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private int size;
    private String productBrand;
    private String productName;
    private String screenType;
    private double price;
    private int stock;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Item(int id, int size,String productBrand, String productName,String screenType, double price, int stock) {
        this.id = id;
        this.size = size;
        this.productBrand = productBrand;
        this.productName = productName;
        this.screenType = screenType;
        this.price = price;
        this.stock = stock;
    }
    
}

class TV42 extends Item{
    public TV42(int id, int size,String productBrand, String productName,String screenType, double price, int stock) {
        super(id, size,productBrand, productName, screenType, price, stock);
    }
}
class TV45 extends Item{
    public TV45(int id, int size,String productBrand, String productName,String screenType, double price, int stock){
        super(id, size,productBrand, productName, screenType, price, stock);
    }
}
class TV49 extends Item{
    public TV49(int id, int size,String productBrand, String productName,String screenType, double price, int stock){
        super(id, size,productBrand, productName, screenType, price, stock);
    }
}
class TV52 extends Item{
    public TV52(int id, int size,String productBrand, String productName,String screenType, double price, int stock){
        super(id, size,productBrand, productName, screenType, price, stock);
    }
}

//class Item3 extends Item{
//    public String getItem(){
//        return "Iphone3";
//    }
//}
//class Item4 extends Item{
//    public String getItem(){
//        return "Iphone4";
//    }
//}
