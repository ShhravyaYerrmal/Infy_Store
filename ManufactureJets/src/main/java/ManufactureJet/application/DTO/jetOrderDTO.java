package ManufactureJet.application.DTO;

import ManufactureJet.application.Entity.jetOrderEntity;

public class jetOrderDTO {
	int orderid;
	String quotationmodelno;
	String customerid;
	String customername;
	String quantity;
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
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	public jetOrderEntity createEntity(jetDto jet) {
		System.out.println("in dto");
		jetOrderEntity entity= new jetOrderEntity();
		entity.setCustomerid(this.customerid);
		entity.setCustomername(this.customername);
		entity.setEmail(this.email);
		entity.setQuantity(this.quantity);
		entity.setPrice(jet.getUnitPrice());
		entity.setQuotationmodelno(this.quotationmodelno);
		return entity;
	}
	

}
