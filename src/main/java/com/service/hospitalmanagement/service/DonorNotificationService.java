package com.service.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hospitalmanagement.entity.DonorNotificationEntity;
import com.service.hospitalmanagement.repository.DonorNotificationRepository;

@Service
public class DonorNotificationService {

    @Autowired
    private DonorNotificationRepository notificationRepository;

    public DonorNotificationEntity findLatestByDonorEmail(String email) {
        return notificationRepository.findTopByDonorUser_EmailOrderByNotificationDateDesc(email);
    }

    public void saveNotification(DonorNotificationEntity notification) {
        notificationRepository.save(notification);
    }

    public DonorNotificationEntity findLatestByDonorId(Long donorId) {
        return notificationRepository.findTopByDonorUser_DonorIdOrderByNotificationDateDesc(donorId);
    }
}