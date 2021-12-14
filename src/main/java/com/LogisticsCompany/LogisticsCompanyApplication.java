package com.LogisticsCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
public class LogisticsCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsCompanyApplication.class, args);
	}

//	@GetMapping("/")
//	public String checkMVC(){
//		return "hello";
//	}
//
//	@GetMapping(path="/greet")
//	public String hello(@RequestParam String name) {
//		return "Hello, " + name + ". Welcome to my site!";
//	}

}
