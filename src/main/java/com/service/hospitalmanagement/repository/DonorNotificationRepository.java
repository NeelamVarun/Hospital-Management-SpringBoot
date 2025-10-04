package com.service.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.hospitalmanagement.entity.DonorNotificationEntity;

@Repository
public interface DonorNotificationRepository extends JpaRepository<DonorNotificationEntity, Long> {

    // Finds the latest notification for a donor by email
    DonorNotificationEntity findTopByDonorUser_EmailOrderByNotificationDateDesc(String email);

    // Finds the latest notification for a donor by donor ID
    DonorNotificationEntity findTopByDonorUser_DonorIdOrderByNotificationDateDesc(Long donorId);
}
