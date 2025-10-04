package com.service.hospitalmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.service.hospitalmanagement.entity.DonorEntity;
import com.service.hospitalmanagement.repository.DonorUserRepository;
@Service
public class DonorUserService {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
  private DonorUserRepository userRepository;
    
    public void registerUser(DonorEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public DonorEntity validateUser(String email, String password) {
        DonorEntity user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public List<DonorEntity> getAllDonars() {
        return userRepository.findAll();
    }

    public DonorEntity getDonarByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public DonorEntity getDonorByDonorId(long donorId) {
        return userRepository.findByDonorId(donorId);
    }
    
    public DonorEntity getUserByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
}