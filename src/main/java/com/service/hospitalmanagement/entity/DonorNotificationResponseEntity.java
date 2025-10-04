package com.service.hospitalmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donor_notification_response")
public class DonorNotificationResponseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String donorEmail;
	private String donorName;
	private String bloodType;
	private LocalDate lastDonationDate;
	private String timeSlot;
	private boolean needsVehicle;
	private boolean available;
	private LocalDate responseDate;

	@ManyToOne
	@JoinColumn(name = "donor_id", referencedColumnName = "donorId")
	private DonorEntity donorUser;

	// Constructors
	public DonorNotificationResponseEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public LocalDate getLastDonationDate() {
		return lastDonationDate;
	}

	public void setLastDonationDate(LocalDate lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public boolean getNeedsVehicle() {
		return needsVehicle;
	}

	public void setNeedsVehicle(boolean needsVehicle) {
		this.needsVehicle = needsVehicle;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public LocalDate getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(LocalDate responseDate) {
		this.responseDate = responseDate;
	}

	public DonorEntity getDonorUser() {
		return donorUser;
	}

	public void setDonorUser(DonorEntity donorUser) {
		this.donorUser = donorUser;
	}

}
