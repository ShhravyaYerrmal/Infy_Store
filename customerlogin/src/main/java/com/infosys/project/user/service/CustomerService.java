package com.infosys.project.user.service;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infosys.project.user.dto.LoginDTO;
import com.infosys.project.user.dto.LoginDTO1;
import com.infosys.project.user.dto.RegisterDTO;

import com.infosys.project.user.entity.CustomerEntity;
import com.infosys.project.user.entity.HistoryEntity;
import com.infosys.project.user.repository.CustomerRepository;
import com.infosys.project.user.repository.HistoryRepository;
import com.infosys.project.user.validator.CustomerValidator;

@Service
public class CustomerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	HistoryRepository historyRepo;
	
	public boolean loginbymail(LoginDTO loginDTO) throws Exception {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(), loginDTO.getPassword());
		try {
		CustomerValidator.emailid(loginDTO.getEmail());
		
		CustomerEntity customer = customerRepo.findByEmail(loginDTO.getEmail());
		
		if (customer.getPassword().equals(loginDTO.getPassword())){
			HistoryEntity entity = new HistoryEntity();
			entity.setCustomerId(customer.getCustomerid());
			historyRepo.save(entity);
			return true;
			}else {
				throw new Exception("Invalid password!");}
			}
		
		catch(Exception e) {
			throw e;
		}
		}
			
	
	public int loginbyphonenumber(LoginDTO1 loginDTO) throws Exception {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhonenumber(), loginDTO.getPassword());
		
		try {
		CustomerValidator.number(loginDTO.getPhonenumber());
		
		CustomerEntity customer = customerRepo.findByphoneNumber(loginDTO.getPhonenumber());
		if (customer.getPassword().equals(loginDTO.getPassword())) {
			HistoryEntity entity = new HistoryEntity();
			entity.setCustomerId(customer.getCustomerid());
			historyRepo.save(entity);
			return customer.getCustomerid();
		}else {
			throw new Exception("Invalid password!");}
		}
		catch(Exception e) {
		throw e;
	}
	}
		
	
		

	public String signInCustomer(RegisterDTO registerDTO) throws Exception {
		
		 {
		logger.info("Registration request for user {}", registerDTO);
		CustomerEntity customer=customerRepo.findByEmail(registerDTO.getEmail());
		CustomerEntity number=customerRepo.findByphoneNumber(registerDTO.getPhoneNumber());
		if(customer==null) {
			if(number==null) {
			CustomerEntity cust=registerDTO.createEntity();
			CustomerValidator.number(registerDTO.getPhoneNumber());
			CustomerValidator.emailid(registerDTO.getEmail()); 
			customerRepo.save(cust);
			return("new user new created, with id:"+ cust.getCustomerid());
		}else {
			return("PhoneNumber already present");
		}
			}
		
		else {
			return("email already present");
		}
		
} }


	public RegisterDTO view(Integer customerid) {
		CustomerEntity customer=customerRepo.findBycustomerid(customerid);
		RegisterDTO dto=RegisterDTO.valueOf(customer);
		return dto;
		
	}


	public boolean viewHistory(Integer customerid) {
		Optional<HistoryEntity> entity= historyRepo.findById(customerid);
		if(entity.isPresent()) {
			System.out.println(entity);
			return true;
		}else {
			System.out.println("false");
			return false;
			
		}
		
	}


	public String logout(Integer customerid) {
		Optional<HistoryEntity> entity= historyRepo.findById(customerid);
		if(entity.isPresent()) {
			historyRepo.deleteById(customerid);
			return "successfully Logged out";
		}else {
			
			return "Customer is not Logged In";
			
		}
	}
		
	}
