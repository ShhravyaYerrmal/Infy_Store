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
			System.out.print("2");
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
				System.out.println(model);
				}
			
			return model;
		}
		public void order(AirbusOrderDTO order) throws Exception {
			Optional<AirbusEntity> entity=airbusRepo.findById(order.getQuotationmodelno());
			System.out.println(entity);
			if(entity.isPresent()) {
				if(order.getQuotationmodelno().equals(entity.get().getManufactureModelNo())) {
					System.out.println("service");
					AirbusDTO model=AirbusDTO.value(entity);
					System.out.println(model+"model");
					AirbusOrderEntity Order= order.createEntity(model);
					System.out.println(order+"order");
					orderrepo.save(Order);
				}
			}else {
				throw new Exception("Invalid Model Number");
			}
			
		}
		public void deleteOrder(String orderid) throws Exception {
			Optional<AirbusOrderEntity> entity= orderrepo.findById(orderid);
			if(entity.isPresent()) {
				orderrepo.deleteById(orderid);
			}else {
				throw new Exception("Order ID Unavailable");
			}
		}

	}


		
		
		
		
		
		

	
										
