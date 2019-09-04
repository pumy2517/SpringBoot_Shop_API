package com.example.SmartShop;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class SmartShopApplication {
	private final AtomicLong counter = new AtomicLong();
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/item")
	public Item[] item() {
		return ItemFactory.getAllItem();
	}

	@RequestMapping(value = "/item/{size}", method = RequestMethod.GET)
    public List<Item> typeItem(@PathVariable int size){
	    return ItemFactory.TypeOfProduct(size);
    }
	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

}
