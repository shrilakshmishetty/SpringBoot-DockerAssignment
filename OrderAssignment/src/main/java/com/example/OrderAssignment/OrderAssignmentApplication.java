package com.example.OrderAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.OrderAssignment.Model")
public class OrderAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAssignmentApplication.class, args);
	}

}
