package com.service.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.hospitalmanagement.entity.DonorEntity;

@Repository
public interface DonorUserRepository  extends JpaRepository<DonorEntity, Long>{

	DonorEntity findByEmail(String email);
	
	DonorEntity findByEmailAndPassword(String email, String password);
	
	DonorEntity findByDonorId(Long donorId);

}
