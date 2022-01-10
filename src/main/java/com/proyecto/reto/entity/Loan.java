package com.proyecto.reto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="loans")
@Table(name = "loans")
public class Loan {
	
	@Id
	private int id;
	
	@Column(name="total")
	private Float total;
	
	@Column(name="user_id")
	private Integer userID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	
	

}
