package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(FirstprojectApplication.class, args);
		System.out.println("Welcome to boot..!");
		
		Alien a= context.getBean(Alien.class);
		a.show();
		
//		Alien a1= context.getBean(Alien.class);  //to check the default singleton behaviour of springboot
//		a1.show();
		
	}

}
