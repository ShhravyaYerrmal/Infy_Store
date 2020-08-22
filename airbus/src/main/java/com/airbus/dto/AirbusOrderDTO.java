package com.airbus.dto;

import com.airbus.entity.AirbusOrderEntity;

//import Airbus.airbus.DTO.AirbusDTO;

public class AirbusOrderDTO {
	int orderid;
	String quotationmodelno;
	String customerid;
	String customername;
	String price;
	String email;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getQuotationmodelno() {
		return quotationmodelno;
	}
	public void setQuotationmodelno(String quotationmodelno) {
		this.quotationmodelno = quotationmodelno;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public AirbusOrderEntity createEntity(AirbusDTO p1) {
		AirbusOrderEntity entity= new AirbusOrderEntity();
		entity.setCustomerid(this.customerid);
		entity.setCustomername(this.customername);
		entity.setEmail(this.email);
		//entity.setOrderid(1);
		entity.setPrice(p1.getUnitPrice());
		entity.setQuotationmodelno(this.quotationmodelno);
		return entity;
	}


}
