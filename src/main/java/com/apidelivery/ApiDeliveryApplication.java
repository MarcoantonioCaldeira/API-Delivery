package com.apidelivery;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@SpringBootApplication
public class ApiDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDeliveryApplication.class, args);
	}

}
