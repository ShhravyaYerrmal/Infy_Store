package com.airbus;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.airbus.service.AirbusService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	    properties = "CATALOG_ENDPOINT=catalog")
class AirbusApplicationTests {
	
	
	 

		@Autowired
	   // private TestRestTemplate restTemplate;
	    
	    @ClassRule
	    public static Class<AirbusService> airbusService = AirbusService.class;
	    
	    
	   
	
	
	
	
	

	@Test
	void contextLoads() {
	}

}
