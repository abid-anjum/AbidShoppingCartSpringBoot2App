package com.abid.cart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.abid.cart.web"})
@EntityScan(basePackages = "com.abid.cart.domain.model")
@EnableJpaRepositories(basePackages = "com.abid.cart.domain.repository")
@ImportResource("classpath:flow-definition.xml")
public class AbidShoppingCartWebApplication {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AbidShoppingCartWebApplication.class);
	public static void main(String[] args) {
		
		LOGGER.info("this is a info message");
		LOGGER.warn("this is a warn message");
		LOGGER.error("this is a error message");
		SpringApplication.run(AbidShoppingCartWebApplication.class, args);
	}

}
