package com.airbus.dto;

import java.util.Optional;

import com.airbus.entity.AirbusEntity;




public class AirbusDTO {

	String manufactureModelNo;
	String modelName;
	String unitPrice;
	String passengerSeats;
	String length;
	String height;
	String wingspan;
	String travelRange;
	String speed;
	String maxFuelCapacity;
	
	
	
	public String getManufactureModelNo() {
		return manufactureModelNo;
	}


	public void setManufactureModelNo(String manufactureModelNo) {
		this.manufactureModelNo = manufactureModelNo;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String getPassengerSeats() {
		return passengerSeats;
	}


	public void setPassengerSeats(String passengerSeats) {
		this.passengerSeats = passengerSeats;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWingspan() {
		return wingspan;
	}


	public void setWingspan(String wingspan) {
		this.wingspan = wingspan;
	}


	public String getTravelRange() {
		return travelRange;
	}


	public void setTravelRange(String travelRange) {
		this.travelRange = travelRange;
	}


	public String getSpeed() {
		return speed;
	}


	public void setSpeed(String speed) {
		this.speed = speed;
	}


	public String getMaxFuelCapacity() {
		return maxFuelCapacity;
	}


	public void setMaxFuelCapacity(String maxFuelCapacity) {
		this.maxFuelCapacity = maxFuelCapacity;
	}


	//Convert Entity to DTO
	public static AirbusDTO valueOf(AirbusEntity entity){
		AirbusDTO airbus= new AirbusDTO();
		airbus.setHeight(entity.getHeight());
		airbus.setLength(entity.getLength());
		airbus.setManufactureModelNo(entity.getManufactureModelNo());
		airbus.setMaxFuelCapacity(entity.getMaxFuelCapacity());
		airbus.setModelName(entity.getModelName());
		airbus.setPassengerSeats(entity.getPassengerSeats());
		airbus.setSpeed(entity.getSpeed());
		airbus.setTravelRange(entity.getTravelRange());
		airbus.setUnitPrice(entity.getUnitPrice());
		airbus.setWingspan(entity.getWingspan());
		return airbus;
	}
	
	
	//Convert DTO to Entity
	public AirbusEntity createEntity(){
		AirbusEntity airbus= new AirbusEntity();
		airbus.setHeight(this.getHeight());
		airbus.setLength(this.getLength());
		airbus.setManufactureModelNo(this.getManufactureModelNo());
		airbus.setMaxFuelCapacity(this.getMaxFuelCapacity());
		airbus.setModelName(this.getModelName());
		airbus.setPassengerSeats(this.getPassengerSeats());
		airbus.setSpeed(this.getSpeed());
		airbus.setTravelRange(this.getTravelRange());
		airbus.setUnitPrice(this.getUnitPrice());
		airbus.setWingspan(this.getWingspan());
		return airbus;
		
		
	}
	public static AirbusDTO value(Optional<AirbusEntity> entity) {
		AirbusDTO p1= new AirbusDTO();
		p1.setHeight(entity.get().getHeight());
		p1.setLength(entity.get().getLength());
		p1.setManufactureModelNo(entity.get().getManufactureModelNo());
		p1.setMaxFuelCapacity(entity.get().getMaxFuelCapacity());
		p1.setModelName(entity.get().getModelName());
		p1.setPassengerSeats(entity.get().getPassengerSeats());
		p1.setSpeed(entity.get().getSpeed());
		p1.setTravelRange(entity.get().getTravelRange());
		p1.setUnitPrice(entity.get().getUnitPrice());
		p1.setWingspan(entity.get().getWingspan());
		return p1;
	}
	

}
