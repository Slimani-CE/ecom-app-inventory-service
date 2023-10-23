package com.slimanice.inventoryservice;

import com.slimanice.inventoryservice.entities.Product;
import com.slimanice.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class InventoryServiceApplication{


	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			Random rnd = new Random();
			for(int i = 1; i <= 10; i++){
				productRepository.save(
						Product.builder()
								.name("Computer " + i)
								.price(rnd.nextInt(10000))
								.quantity(rnd.nextInt(10))
								.build()
				);
			}
		};
	}
}
