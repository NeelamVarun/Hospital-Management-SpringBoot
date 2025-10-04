package com.service.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.hospitalmanagement.entity.DonorNotificationResponseEntity;
import com.service.hospitalmanagement.repository.DonorNotificationResponseRepository;

@Service
public class DonorNotificationResponseService {

    @Autowired
    private DonorNotificationResponseRepository repository;

    public void saveResponse(DonorNotificationResponseEntity response) {
        repository.save(response);
    }

    public DonorNotificationResponseEntity findLatestByDonorId(Long donorId) {
        return repository.findTopByDonorUser_DonorIdOrderByResponseDateDesc(donorId);
    }
}