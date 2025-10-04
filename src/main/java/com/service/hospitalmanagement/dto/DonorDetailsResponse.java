package com.service.hospitalmanagement.dto;
import java.time.LocalDate;

public class DonorDetailsResponse {
    private long donorId;
    private String name;
    private String contact;
    private String bloodGroup;
    private LocalDate lastDonatedDate;
    private LocalDate notifiedDate;
    private boolean hasNotification;
    private boolean hasResponded;

    public DonorDetailsResponse() {
    }

    public DonorDetailsResponse(Long donorId, String name, boolean hasNotification, String contact, String bloodGroup, LocalDate lastDonatedDate, LocalDate notifiedDate, boolean hasResponded) {
        this.donorId = donorId;
        this.name = name;
        this.hasNotification = hasNotification;
        this.contact = contact;
        this.bloodGroup = bloodGroup;
        this.lastDonatedDate = lastDonatedDate;
        this.notifiedDate = notifiedDate;
        this.hasResponded = hasResponded;
    }

    public boolean isHasResponded() {
        return hasResponded;
    }

    public void setHasResponded(boolean hasResponded) {
        this.hasResponded = hasResponded;
    }

    public LocalDate getNotifiedDate() {
        return notifiedDate;
    }

    public void setNotifiedDate(LocalDate notifiedDate) {
        this.notifiedDate = notifiedDate;
    }

    public long getDonorId() {
        return donorId;
    }

    public void setDonorId(long donorId) {
        this.donorId = donorId;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public LocalDate getLastDonatedDate() {
        return lastDonatedDate;
    }

    public void setLastDonatedDate(LocalDate lastDonatedDate) {
        this.lastDonatedDate = lastDonatedDate;
    }

	public boolean isHasNotification() {
		return hasNotification;
	}

	public void setHasNotification(boolean hasNotification) {
		this.hasNotification = hasNotification;
	}

    
}
