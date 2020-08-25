package com.airbus.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airbus.dto.AirbusDTO;
import com.airbus.dto.AirbusOrderDTO;
import com.airbus.entity.AirbusEntity;
import com.airbus.entity.AirbusOrderEntity;
import com.airbus.repository.AirbusRepository;
import com.airbus.repository.ProjectOrderRepository;

@Transactional
@Service
public class AirbusService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AirbusRepository airbusRepo;
	
	@Autowired
	ProjectOrderRepository orderrepo;
	
		// Fetches all air bus models with their details
		public List<AirbusDTO> getAllAirbus() {
			List<AirbusEntity> airbus = airbusRepo.findAll();
			List<AirbusDTO> airbusDTOs = new ArrayList<>();

			for (AirbusEntity abus : airbus) {
				AirbusDTO airbusDTO = AirbusDTO.valueOf(abus);
				airbusDTOs.add(airbusDTO);
			}

			logger.info("Airbus details : {}", airbusDTOs);
			return airbusDTOs;
		}
		
		
		//view order
		public List<AirbusOrderDTO> getorder(String customerid) {
			List<AirbusOrderEntity> entity= orderrepo.findAll();
			logger.info("Customerid in database details : {}",entity);
			List<AirbusOrderDTO> orderList= new ArrayList<>();
		
			for(AirbusOrderEntity a1:entity) {		
				if(a1.getCustomerid().equalsIgnoreCase(customerid) ){
				
				
				logger.info("Customer id in database details : {}", a1.getCustomerid());
				AirbusOrderDTO order = AirbusOrderDTO.valueOf(a1);
				orderList.add(order);
				logger.info("order present in database details : {}",order);
				}
			}	
			return orderList;
			
			
			
		}
		
		
		// To get a air bus based on air bus name
		public AirbusDTO getAirbus(String modelName) {
			AirbusDTO airbusDTO = null;
			Optional<AirbusEntity> optairbus = airbusRepo.findBymodelName(modelName);
			if (optairbus.isPresent()) {
				AirbusEntity airbus = optairbus.get();
				airbusDTO = AirbusDTO.valueOf(airbus);
			}
			
			
			logger.info("Airbus details : {}", airbusDTO);
			return airbusDTO;
		}
		
		// fetching all models
		public List<AirbusDTO> getModel(){
			List<AirbusEntity> model= airbusRepo.findAll();
			List<AirbusDTO> modelList= new ArrayList<>();
			
			for(AirbusEntity a1:model) {
				AirbusDTO airbusModel = AirbusDTO.valueOf(a1);
				modelList.add(airbusModel);
			}
			return modelList;
		}
		
		//fetching model by model number
		public AirbusDTO getModelById(String manufactureModelNo) {
			AirbusDTO model= null;
			Optional<AirbusEntity> entity=airbusRepo.findById(manufactureModelNo);
			if(entity.isPresent()) {
				AirbusEntity airbus= entity.get();
				model=AirbusDTO.valueOf(airbus);
				logger.info("Customer id in database details : {}", model);
				}
			
			return model;
		}
		
		//create order
		public void order(AirbusOrderDTO order) throws Exception {
			Optional<AirbusEntity> entity=airbusRepo.findById(order.getQuotationmodelno());
			
			if(entity.isPresent()) {
				if(order.getQuotationmodelno().equals(entity.get().getManufactureModelNo())) {
					
					AirbusDTO model=AirbusDTO.value(entity);					
					AirbusOrderEntity Order= order.createEntity(model);					
					orderrepo.save(Order);
				}
			}else {
				throw new Exception("Invalid Model Number");
			}
			
		}
		
		//delete order
		public void deleteOrder(String orderid) throws Exception {
			Optional<AirbusOrderEntity> entity= orderrepo.findById(orderid);
			if(entity.isPresent()) {
				orderrepo.deleteById(orderid);
			}else {
				throw new Exception("Order ID Unavailable");
			}
		}

	

		
	}


		
		
		
		
		
		

	
										
