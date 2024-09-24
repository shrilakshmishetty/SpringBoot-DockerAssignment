package com.example.MicroServicesAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.MicroServicesAssignment.Model")
public class MicroServicesAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesAssignmentApplication.class, args);
	}

}
