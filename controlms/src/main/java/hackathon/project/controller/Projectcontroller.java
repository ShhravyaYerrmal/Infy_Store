package hackathon.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import hackathon.project.DTO.ProjectDTO;
import hackathon.project.DTO.ProjectOrderDTO;
import hackathon.project.service.Projectservice;

@RestController
@RequestMapping("/api")
public class Projectcontroller {
	@Autowired
	Projectservice service;
	@Autowired
	Environment environment;
	
	@Autowired
	RestTemplate restTemplate;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(value="/models/{customerid}")
	public List<ProjectDTO> viewmodel(@PathVariable Integer customerid) throws Exception{
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		List<ProjectDTO> dto=service.getmodel();
		return dto;
	}else {
		throw new Exception("Cusomer not Logged In");
	}
	}
	
	@GetMapping(value="/models/{customerid}/{manufacture_model_no}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ProjectDTO viewModelById(@PathVariable String manufacture_model_no,@PathVariable Integer customerid) throws Exception{
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		ProjectDTO Model= service.getModelById(manufacture_model_no);
		return Model;
	}else {
		throw new Exception("Cusomer not Logged In");
	}
	}

	@PostMapping(value="/order/{customerid}")
	public String order(@RequestBody ProjectOrderDTO order,@PathVariable Integer customerid) {
		
		
		try {
			boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
			if(customer==true){
			
			service.order(order);
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
		service.deleteOrder(order_id);
		return "Deleted Successfully";
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		}catch(Exception e) {
			return "Order ID Unavailable";
		}
		
	}

}
