package com.example.SmartShop;
import java.io.*;
import java.util.List;

public class FileSingleton {
    private static FileSingleton singel_instance = null;
    private static File file;

    private FileSingleton(){
        this.file = new File("listItem.txt");
        if (!file.exists()){
            System.out.println("CHECKCHECK");
            ItemFactory.CreateProduct.add(ItemFactory.createItem(1,42,"LG","LG8042X", "LED",999.99, 10));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(2,45,"SAMSUNG","S80X45", "OLED",999.99, 5));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(3,49,"MI","5400KL", "LED",599.99, 2));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(4,52,"SONY","HD9000ATV", "OLED",899.99, 3));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(5,52,"SONY","HD8500ATV", "LED",699.99, 2));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(6,42,"LG","LG9042X", "OLED",1699.99, 2));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(7,49,"SAMSUNG","S85X49", "LED",699.99, 2));
            ItemFactory.CreateProduct.add(ItemFactory.createItem(8,52,"SAMSUNG","S95X52", "OLED",699.99, 2));
            FileSingleton.SaveFile(ItemFactory.CreateProduct);
        }
    }

    public static FileSingleton getInstance(){
        if (singel_instance == null){
            singel_instance = new FileSingleton();
            System.out.println("Check File");
        }
        else{
            System.out.println("Already Checked");
        }
        return singel_instance;
    }

    public static List<Item> LoadFile(){
        try {

            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            List<Item> list = (List<Item>) objectInput.readObject();
            objectInput.close();
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void SaveFile(List<Item> list){
        try {
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(list);
            objectOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
