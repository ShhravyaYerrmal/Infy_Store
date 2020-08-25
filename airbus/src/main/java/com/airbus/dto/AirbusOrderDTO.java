package com.airbus.dto;

import com.airbus.entity.AirbusOrderEntity;

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
		entity.setPrice(p1.getUnitPrice());
		entity.setQuotationmodelno(this.quotationmodelno);
		return entity;
	}
	public static AirbusOrderDTO valueOf(AirbusOrderEntity a1) {
		AirbusOrderDTO order= new AirbusOrderDTO();
		order.setCustomerid(a1.getCustomerid());
		order.setOrderid(a1.getOrderid());
		order.setCustomername(a1.getCustomername());
		order.setEmail(a1.getEmail());
		order.setQuotationmodelno(a1.getQuotationmodelno());
		order.setPrice(a1.getPrice());
		return order;
	}


}
