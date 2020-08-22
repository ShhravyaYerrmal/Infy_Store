package ManufactureJet.application.controller;

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

import ManufactureJet.application.DTO.jetDto;
import ManufactureJet.application.DTO.jetOrderDTO;
import ManufactureJet.application.service.jetService;
@RestController
@RequestMapping(value="/api")
public class jetcontroller {
	@Autowired
	jetService service;
	@Autowired
	Environment environment;
	@Autowired
	RestTemplate restTemplate;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/jetmodels/{customerid}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<jetDto> viewModel(@PathVariable Integer customerid) throws Exception{
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		List<jetDto> jetModel= service.getModel();
		return jetModel;
		}else {
			throw new Exception("Cusomer not Logged In");
		}
	}
	@GetMapping(value="/modelid/{customerid}/{manufacture_model_no}", produces= MediaType.APPLICATION_JSON_VALUE)
	public jetDto viewModelById(@PathVariable String manufacture_model_no, @PathVariable Integer customerid) throws Exception{
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		jetDto jetModel= service.getModelById(manufacture_model_no);
		return jetModel;
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		
	}
	
	@GetMapping(value="/modelname/{customerid}/{model_name}", produces= MediaType.APPLICATION_JSON_VALUE)
	public jetDto viewModelByName(@PathVariable String model_name, @PathVariable Integer customerid) throws Exception{
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		jetDto jetModel= service.getModelByName(model_name);
		return jetModel;
		}else {
			throw new Exception("Cusomer not Logged In");
		}
	}
	
	
	
	@PostMapping(value="/order/{customerid}")
	public String orderJet(@RequestBody jetOrderDTO order, @PathVariable Integer customerid) {
		try {
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		service.orderJet(order);
		return "Order Added Successfully";
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	@DeleteMapping(value="/delete/{customerid}/{order_id}")
	public String deleteOrder(@PathVariable Integer customerid,@PathVariable Integer order_id) {
		try {
		boolean customer= restTemplate.getForObject("http://localhost:8300"+"/viewhistory/"+customerid, Boolean.class);
		if(customer==true){
		service.deleteOrder(order_id);
		return "Deleted Successfully";
		}else {
			throw new Exception("Cusomer not Logged In");
		}
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	

}
