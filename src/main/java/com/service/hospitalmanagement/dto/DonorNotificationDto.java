package com.service.hospitalmanagement.dto;

public class DonorNotificationDto {

    private int donorId;
    private boolean hasNotifcation;

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public boolean isHasNotifcation() {
        return hasNotifcation;
    }

    public void setHasNotifcation(boolean hasNotifcation) {
        this.hasNotifcation = hasNotifcation;
    }
}