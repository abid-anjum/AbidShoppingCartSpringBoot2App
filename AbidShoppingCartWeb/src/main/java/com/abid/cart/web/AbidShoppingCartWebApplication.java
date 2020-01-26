package com.abid.cart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.abid.cart.web"})
@EntityScan(basePackages = "com.abid.cart.domain.model")
@EnableJpaRepositories(basePackages = "com.abid.cart.domain.repository")
public class AbidShoppingCartWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbidShoppingCartWebApplication.class, args);
	}

}
