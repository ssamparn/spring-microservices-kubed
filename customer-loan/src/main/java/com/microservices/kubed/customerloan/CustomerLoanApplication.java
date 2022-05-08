package com.microservices.kubed.customerloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class CustomerLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoanApplication.class, args);
	}

}
