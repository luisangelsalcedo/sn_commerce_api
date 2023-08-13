package com.cibertec.commerceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommerceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceapiApplication.class, args);
	}

}
