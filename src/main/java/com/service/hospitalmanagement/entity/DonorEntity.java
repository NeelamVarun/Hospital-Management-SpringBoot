package com.service.hospitalmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donor_user")
public class DonorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donorId;

	private String name;
	private String gender;
	private String bloodGroup;
	private String contact;
	private String email;
	private String address;
	private String password;
	private LocalDate dateOfBirth;
	private LocalDate lastDonatedDate;

	public DonorEntity() {
	}


	public Long getDonorId() {
		return donorId;
	}


	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getLastDonatedDate() {
		return lastDonatedDate;
	}

	public void setLastDonatedDate(LocalDate lastDonatedDate) {
		this.lastDonatedDate = lastDonatedDate;
	}

}