package com.example.SmartShop;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {
    public static List<Item> CreateProduct = new ArrayList<Item>();
    static {
            CreateProduct.add(ItemFactory.createItem(1,42,"LG","LG8042X", "LED",999.99, 10));
            CreateProduct.add(ItemFactory.createItem(2,45,"SAMSUNG","S80X45", "OLED",999.99, 5));
            CreateProduct.add(ItemFactory.createItem(3,49,"MI","5400KL", "LED",599.99, 2));
            CreateProduct.add(ItemFactory.createItem(4,52,"SONY","HD9000ATV", "OLED",899.99, 3));
            CreateProduct.add(ItemFactory.createItem(5,52,"SONY","HD8500ATV", "LED",699.99, 2));
            CreateProduct.add(ItemFactory.createItem(6,42,"LG","LG9042X", "OLED",1699.99, 2));
            CreateProduct.add(ItemFactory.createItem(7,49,"SAMSUNG","S85X49", "LED",699.99, 2));
            CreateProduct.add(ItemFactory.createItem(8,52,"SAMSUNG","S95X52", "OLED",699.99, 2));
    };

    public static List<Item> getAllItem(){
        return CreateProduct;
    }

    public static List<Item> TypeOfProduct(int size){
        List<Item> query = new ArrayList<Item>();
        for(Item typeItem : CreateProduct){
            if(typeItem.getSize() == size){
                query.add(typeItem);
            }

        }
        return query;
    }
    public static List<Item> addItem(int size,String productBrand,String productName,String screenType, double price, int stock){
        int countItem = CreateProduct.size();
        countItem += 1;
        CreateProduct.add(ItemFactory.createItem(countItem,size, productBrand, productName,screenType,price,stock));
        return CreateProduct;
    }

    public static Item createItem(int id,int size,String productBrand,String productName,String screenType, double price, int stock){
        if(size == 42)
            return new TV42(id, size,productBrand, productName, screenType, price, stock);
        else if(size == 45)
            return new TV45(id, size,productBrand, productName, screenType, price, stock);
        else if(size == 49)
            return new TV49(id, size,productBrand, productName, screenType, price, stock);
        else if(size == 52)
            return new TV52(id, size,productBrand, productName, screenType, price, stock);
//        else if(type.equals("3"))
//            return new Item3();
//        else if(type.equals("4"))
//            return new Item4();
        else
            return null;
    }
}
