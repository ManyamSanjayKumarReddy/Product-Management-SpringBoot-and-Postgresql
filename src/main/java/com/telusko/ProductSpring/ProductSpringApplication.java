package com.telusko.ProductSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);

		// The way of getting the objects from the Spring Container
		ProductService service = context.getBean(ProductService.class);

		System.out.println("Get all the Products in the Inventory :");
		List<Product> products =  service.getAllProducts();
		// Enhanced For Loop
		for(Product p : products){
			System.out.println(p);
		}

		System.out.println("==========================================================================");
		System.out.println("Get a Particular Product :");

		Product Name = service.getProduct("Type C");
		System.out.println(Name);

		System.out.println("==========================================================================");
		System.out.println("Get a Particular text in the Inventory :");

		List<Product> prods = service.getProductText("black");
		for(Product product : prods){
			System.out.println(product);
		}

		System.out.println("==========================================================================");
		System.out.println("Get a Particular Product from it's Place :");

		List<Product> prods_place = service.getProductsByPlace("Shelf");
		for(Product place : prods_place){
			System.out.println(place);
		}

		System.out.println("==========================================================================");
		System.out.println("Get all the Products that are out or warranty :");

		List<Product> Out_Warranty = service.getProdswithOutofWarranty(2023);
		for(Product warranty : Out_Warranty){
			System.out.println(warranty);
		}
	}
}
