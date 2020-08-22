package com.infosys.project.user.validator;

public class CustomerValidator {
	public static void number(String number) throws Exception {
		if (!(number.matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$"))){
		throw new Exception("Invalid phonenumber!");
		}
	}
	
		
		
	
	public static void emailid(String mail) throws Exception {
		if(!(mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
				"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
		throw new Exception("Invalid mail id!");
}}}
