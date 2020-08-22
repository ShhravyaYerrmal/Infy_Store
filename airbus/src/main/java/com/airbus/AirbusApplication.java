package com.airbus;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan
@EnableDiscoveryClient
public class AirbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbusApplication.class, args);
	}
	
	//@Bean
	   //public RestTemplate getRestTemplate() {
	     //return new RestTemplate();
	   //}
	
		

}
