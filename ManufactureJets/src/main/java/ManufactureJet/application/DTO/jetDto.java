package ManufactureJet.application.DTO;



import java.util.Optional;

import ManufactureJet.application.Entity.jetEntity;

public class jetDto {
	String manufactureModelNo;
	String modelName;
	String unitPrice;
	String passengerSeats;
	String length;
	String height;
	String wingspan;
	String travel_Range;
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

	public String getTravel_Range() {
		return travel_Range;
	}

	public void setTravel_Range(String travel_Range) {
		this.travel_Range = travel_Range;
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

	public static jetDto valueOf(jetEntity entity){
		jetDto jetModel= new jetDto();
		jetModel.setHeight(entity.getHeight());
		jetModel.setLength(entity.getLength());
		jetModel.setManufactureModelNo(entity.getManufactureModelNo());
		jetModel.setMaxFuelCapacity(entity.getMaxFuelCapacity());
		jetModel.setModelName(entity.getModelName());
		jetModel.setPassengerSeats(entity.getPassengerSeats());
		jetModel.setSpeed(entity.getSpeed());
		jetModel.setTravel_Range(entity.getTravel_Range());
		jetModel.setUnitPrice(entity.getUnitPrice());
		jetModel.setWingspan(entity.getWingspan());
		return jetModel;
	}
	
	public static jetDto value(Optional<jetEntity> entity) {
		jetDto jet= new jetDto();
		jet.setHeight(entity.get().getHeight());
		jet.setLength(entity.get().getLength());
		jet.setManufactureModelNo(entity.get().getManufactureModelNo());
		jet.setMaxFuelCapacity(entity.get().getMaxFuelCapacity());
		jet.setModelName(entity.get().getModelName());
		jet.setPassengerSeats(entity.get().getPassengerSeats());
		jet.setSpeed(entity.get().getSpeed());
		jet.setTravel_Range(entity.get().getTravel_Range());
		jet.setUnitPrice(entity.get().getUnitPrice());
		jet.setWingspan(entity.get().getWingspan());
		return jet;
	}
}
