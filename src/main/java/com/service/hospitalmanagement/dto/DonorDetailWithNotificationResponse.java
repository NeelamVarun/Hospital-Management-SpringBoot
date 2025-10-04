package com.service.hospitalmanagement.dto;

import java.time.LocalDate;

public class DonorDetailWithNotificationResponse {
	
	 private String name;
	    private String contact;
	    private String bloodGroup;
	    private LocalDate lastDonatedDate;
	    private LocalDate responseDate;
	    private boolean isVehicleNeed;
	    private boolean isAvailable;
	    private String availableSlot;
	    private long donorId;
	    
	    public DonorDetailWithNotificationResponse() {
	    	
	    }
	    
	    
		public DonorDetailWithNotificationResponse(String name, String contact, String bloodGroup,
				LocalDate lastDonatedDate, LocalDate responseDate, boolean isVehicleNeed, boolean isAvailable,
				String availableSlot, long donorId) {
			super();
			this.name = name;
			this.contact = contact;
			this.bloodGroup = bloodGroup;
			this.lastDonatedDate = lastDonatedDate;
			this.responseDate = responseDate;
			this.isVehicleNeed = isVehicleNeed;
			this.isAvailable = isAvailable;
			this.availableSlot = availableSlot;
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
		public LocalDate getResponseDate() {
			return responseDate;
		}
		public void setResponseDate(LocalDate responseDate) {
			this.responseDate = responseDate;
		}
		public boolean isVehicleNeed() {
			return isVehicleNeed;
		}
		public void setVehicleNeed(boolean isVehicleNeed) {
			this.isVehicleNeed = isVehicleNeed;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public String getAvailableSlot() {
			return availableSlot;
		}
		public void setAvailableSlot(String availableSlot) {
			this.availableSlot = availableSlot;
		}
		public long getDonorId() {
			return donorId;
		}
		public void setDonorId(long donorId) {
			this.donorId = donorId;
		}


	    

}
