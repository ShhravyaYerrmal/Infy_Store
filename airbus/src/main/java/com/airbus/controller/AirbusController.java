package com.airbus.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.airbus.dto.AirbusDTO;
import com.airbus.dto.AirbusOrderDTO;
import com.airbus.exception.NonPrivileged;
import com.airbus.service.AirbusService;





@RestController
@EnableAutoConfiguration
@CrossOrigin
public class AirbusController {	

	Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	RestTemplate restTemplate;
    
	@Autowired
    AirbusService airbusService;
	
	
	
	
		@GetMapping(value = "/modelname/{customerid}/{modelname}", produces = MediaType.APPLICATION_JSON_VALUE)
		public AirbusDTO getAirbus(@Valid @PathVariable("modelname") String modelname,@PathVariable Integer customerid) throws Exception {
			boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
			if(customer==true){
			return airbusService.getAirbus(modelname);
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		}

	//To get all models
		@GetMapping(value="/airbusmodel/{customerid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public List<AirbusDTO> viewModel(@PathVariable Integer customerid) throws Exception{	
			boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
			if(customer==true){
			System.out.print("1");
			List<AirbusDTO> airbusModel= airbusService.getModel();
			return airbusModel;
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		}
		
	//To get details by model_no
		@GetMapping(value="/modelno/{customerid}/{manufacture_model_no}", produces= MediaType.APPLICATION_JSON_VALUE)
		public AirbusDTO viewModelById(@PathVariable String manufacture_model_no,@PathVariable Integer customerid) throws Exception{
			boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
			if(customer==true){
			System.out.println(manufacture_model_no);
			AirbusDTO airbusModel= airbusService.getModelById(manufacture_model_no);
			return airbusModel;
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		}
		@PostMapping(value="/order/{customerid}")
		public String order(@RequestBody AirbusOrderDTO order,@PathVariable Integer customerid) {
			
			try {
				boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
				if(customer==true){
				System.out.println(order);
				airbusService.order(order);
				return "Order Added Successfully";
				}else {
					throw new Exception("Cusomer not Logged In");
				}
				}catch(Exception e) {
					return "Invalid Quotation Model Number";
				}
			
		}
		@DeleteMapping(value="/delete/{customerid}/{order_id}")
		public String deleteOrder(@PathVariable String order_id,@PathVariable Integer customerid) {
			try {
				boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
				if(customer==true){
			airbusService.deleteOrder(order_id);
			return "Deleted Successfully";
			}else {
				throw new Exception("Cusomer not Logged In");
			}
				}
			catch(Exception e) {
				return "Order ID Unavailable";
			}
			
		}

	}

		
		
			
		
		
	

	

