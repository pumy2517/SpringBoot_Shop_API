package com.example.SmartShop;
import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    public static List<Item> CreateProduct = new ArrayList<Item>();
    public static FileSingleton file;
    static {
            file = FileSingleton.getInstance();
            CreateProduct = file.LoadFile();
    };

    public static List<Item> getAllItem(){
        return file.LoadFile();
    }

    public static List<Item> TypeOfProduct(int size){
        List<Item> query = new ArrayList<Item>();
        for(Item typeItem : file.LoadFile()){
            if(typeItem.getSize() == size){
                query.add(typeItem);
            }

        }
        return query;
    }
    public static List<Item> addItem(int size,String productBrand,String productName,String screenType, double price, int stock){
        int countItem = file.LoadFile().size();
        countItem += 1;
        CreateProduct.add(ItemFactory.createItem(countItem,size, productBrand, productName,screenType,price,stock));
        file.SaveFile(CreateProduct);
        return file.LoadFile();
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
        else
            return null;
    }
}
