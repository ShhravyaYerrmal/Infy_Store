package com.airbus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AIRBUS")
public class AirbusEntity{
	
	@Id
	@Column(name="manufacture_model_no")
	String manufactureModelNo;
	@Column(name="model_name")
	String modelName;
	@Column(name="unit_price")
	String unitPrice;
	@Column(name="passenger_seats")
	String passengerSeats;
	@Column(name="length")
	String length;
	@Column(name="height")
	String height;
	@Column(name="wingspan")
	String wingspan;
	@Column(name="travel_range")
	String travelRange;
	@Column(name="speed")
	String speed;
	@Column(name="max_fuel_capacity")
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
}