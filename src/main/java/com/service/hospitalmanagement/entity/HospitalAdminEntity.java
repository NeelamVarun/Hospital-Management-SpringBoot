package com.service.hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospital_admin")

public class HospitalAdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hospitalAdminId;

	private String name;
	private String contact;
	private String email;
	private String password;
	
	public HospitalAdminEntity() {
		
	}
	public Long getHospitalAdminId() {
		return hospitalAdminId;
	}
	public void setHospitalAdminId(Long hospitalAdminId) {
		this.hospitalAdminId = hospitalAdminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
