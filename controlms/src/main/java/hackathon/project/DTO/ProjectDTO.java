package hackathon.project.DTO;

import java.util.Optional;


import hackathon.project.Entity.ProjectEntity;

public class ProjectDTO {
	String systemid;
	String manufactureid;
	String modelName;
	String cost;
	String efficiency;
	String noofemployees;
	String updaterequired;
	
	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public String getManufactureid() {
		return manufactureid;
	}
	public void setManufactureid(String manufactureid) {
		this.manufactureid = manufactureid;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}
	public String getNoofemployees() {
		return noofemployees;
	}
	public void setNoofemployees(String noofemployees) {
		this.noofemployees = noofemployees;
	}
	public String getUpdaterequired() {
		return updaterequired;
	}
	public void setUpdaterequired(String updaterequired) {
		this.updaterequired = updaterequired;
	}
	public static  ProjectDTO valueof(ProjectEntity e1) {
		System.out.println(e1+"in dto class");
		ProjectDTO Dto=new ProjectDTO();
		Dto.setSystemid(e1.getSystemid());
		Dto.setManufactureid(e1.getManufactureid());
		Dto.setModelName(e1.getModelname());
		Dto.setCost(e1.getCost());
		Dto.setEfficiency(e1.getEfficiency());
		Dto.setNoofemployees(e1.getNoofemployees());
		Dto.setUpdaterequired(e1.getUpdaterequired());
		System.out.println(Dto+"in dto class");
		return Dto;
	}
	public static ProjectDTO value(Optional<ProjectEntity> entity) {
		ProjectDTO p1= new ProjectDTO();
		p1.setCost(entity.get().getCost());
		p1.setEfficiency(entity.get().getEfficiency());
		p1.setManufactureid(entity.get().getManufactureid());
		p1.setModelName(entity.get().getModelname());
		p1.setNoofemployees(entity.get().getNoofemployees());
		p1.setSystemid(entity.get().getSystemid());
		p1.setUpdaterequired(entity.get().getUpdaterequired());
		return p1;
	}
	
}
