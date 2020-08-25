package com.airbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class AirbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbusApplication.class, args);
	}
	

	
		

}
