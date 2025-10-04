package com.service.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.hospitalmanagement.entity.HospitalAdminEntity;

@Repository
public interface HospitalAdminRepository extends JpaRepository<HospitalAdminEntity, Long>{

	HospitalAdminEntity findByEmail(String email);

}
