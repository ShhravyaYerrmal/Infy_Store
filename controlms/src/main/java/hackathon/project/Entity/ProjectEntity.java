package hackathon.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTROL")
public class ProjectEntity {
	@Column(name="system_id")
	String systemid;
	@Id
	@Column(name="manufacture_id")
	String manufactureid;
	@Column(name="model_name")
	String modelname;
	String cost;
	String efficiency;
	@Column(name="no_of_employees")
	String noofemployees;
	@Column(name="update_required")
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
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
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


}
