package com.infosys.project.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HISTORY")
public class HistoryEntity {
	@Id
	@Column(name="CUSTOMERID")
	private Integer customerId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
}
