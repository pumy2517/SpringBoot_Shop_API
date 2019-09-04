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
		return "TV SHOP \n" +
				"/item for all item \n" +
				"/item/{size} for search size of tv Ex.42 45 49 52 \n" +
				"/additem for add item (method POST)";
	}
	
	@RequestMapping("/item")
	public List<Item> item() {
		return ItemFactory.getAllItem();
	}

	@RequestMapping(value = "/item/{size}", method = RequestMethod.GET)
    public List<Item> typeItem(@PathVariable int size){
	    return ItemFactory.TypeOfProduct(size);
    }
	@PostMapping("/addItem")
	List<Item> addItem(
				@RequestParam(value="size", defaultValue="42") int size
				,@RequestParam(value="productBrand", defaultValue="World") String productBrand
				,@RequestParam(value="productName", defaultValue="World") String productName
				,@RequestParam(value="screenType", defaultValue="World") String screenType
				,@RequestParam(value="price", defaultValue="899.99") double price
				,@RequestParam(value="stock", defaultValue="10") int stock){
		return ItemFactory.addItem(size, productBrand, productName, screenType, price, stock);
	}
	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

}
