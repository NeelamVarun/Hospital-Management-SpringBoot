package com.service.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.hospitalmanagement.entity.DonorNotificationResponseEntity;

@Repository
public interface DonorNotificationResponseRepository extends JpaRepository<DonorNotificationResponseEntity, Long> {

    DonorNotificationResponseEntity findTopByDonorUser_DonorIdOrderByResponseDateDesc(Long donarId);
}