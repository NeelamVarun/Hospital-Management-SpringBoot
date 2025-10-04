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
@Table(name = "donor_notification_details")
public class DonorNotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String donorName;

	@ManyToOne
	@JoinColumn(name = "donor_id", referencedColumnName = "donorId")
	private DonorEntity donorUser;

	private String hasNotification;
	private LocalDate notificationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public DonorEntity getDonorUser() {
		return donorUser;
	}

	public void setDonorUser(DonorEntity donorUser) {
		this.donorUser = donorUser;
	}

	public String getHasNotification() {
		return hasNotification;
	}

	public void setHasNotification(String hasNotification) {
		this.hasNotification = hasNotification;
	}

	public LocalDate getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(LocalDate notificationDate) {
		this.notificationDate = notificationDate;
	}

}