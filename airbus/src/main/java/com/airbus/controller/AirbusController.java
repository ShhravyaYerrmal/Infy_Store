package com.airbus.controller;

import java.util.List;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.airbus.dto.AirbusDTO;
import com.airbus.dto.AirbusOrderDTO;

import com.airbus.service.AirbusService;





@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(value="/api")
public class AirbusController {	
	
	
	@Autowired
	RestTemplate restTemplate;	
	
    
	@Autowired
    AirbusService airbusService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	//To get all models based on name
	@GetMapping(value = "/modelname/{customerid}/{modelname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AirbusDTO getAirbusbymodelname(@Valid @PathVariable("modelname") String modelname,@PathVariable Integer customerid) throws Exception {
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/api/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
				return airbusService.getAirbus(modelname);
		}else 
		{
		throw new Exception("Customer has not logged In Please login first ");
		}
	}

	//To get all models
		@GetMapping(value="/airbusmodel/{customerid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public List<AirbusDTO> viewAllModel(@PathVariable Integer customerid) throws Exception{	
			boolean customer= restTemplate.getForObject("http://localhost:8300"+"/api/viewhistory/"+customerid, Boolean.class);
			if(customer==true){
			
			List<AirbusDTO> airbusModel= airbusService.getModel();
			return airbusModel;
		}else {
			throw new Exception(" Customer has not logged In Please login first");
		}
		}
		
	//To get details by model_no
		@GetMapping(value="/modelno/{customerid}/{manufacture_model_no}", produces= MediaType.APPLICATION_JSON_VALUE)
		public AirbusDTO viewModelById(@PathVariable String manufacture_model_no,@PathVariable Integer customerid) throws Exception{
			boolean customer= restTemplate.getForObject("http://localhost:8300"+"/api/viewhistory/"+customerid, Boolean.class);
			if(customer==true){
			System.out.println(manufacture_model_no);
			AirbusDTO airbusModel= airbusService.getModelById(manufacture_model_no);
			return airbusModel;
		}else {
			throw new Exception("Customer has not logged In Please login first");
		}
		}
		
		// An order
		@PostMapping(value="/order/{customerid}",consumes= MediaType.APPLICATION_JSON_VALUE)
		public String createorder(@RequestBody AirbusOrderDTO order,@PathVariable Integer customerid) {
			
			try {
				boolean customer= restTemplate.getForObject("http://localhost:8300"+"/api/viewhistory/"+customerid, Boolean.class);
				if(customer==true){
				
				airbusService.order(order);
				return "Order Added Successfully";
				}else {
					throw new Exception("Customer has not logged In Please login first");
				}
				}catch(Exception e) {
					return "Invalid Quotation Model Number";
				}
			
		}
		
		//Deleting an order
		@DeleteMapping(value="/delete/{customerid}/{order_id}")
		public String deleteOrder(@PathVariable String order_id,@PathVariable Integer customerid) {
			try {
				boolean customer= restTemplate.getForObject("http://localhost:8300"+"/api/viewhistory/"+customerid, Boolean.class);
				if(customer==true){
			airbusService.deleteOrder(order_id);
			return "Deleted Successfully";
			}else {
				throw new Exception("Customer has not logged In Please login first");
			}
				}
			catch(Exception e) {
				return "Order ID Unavailable";
			}
			
		}
		
		//Getting all orders 
		@GetMapping(value="/order/{customerid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public List<AirbusOrderDTO> getorders(@PathVariable String customerid)throws Exception {		
			
				boolean customer= restTemplate.getForObject("http://localhost:8300"+"/api/viewhistory/"+customerid, Boolean.class);
				if(customer==true){			
					
				return airbusService.getorder(customerid);
				}else {
					throw new Exception("Customer has not logged In Please login first");
				}
				
			
		}
		
		
		

	}

		
		
			
		
		
	

	

