package com.service.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.service.hospitalmanagement.entity.HospitalAdminEntity;
import com.service.hospitalmanagement.repository.HospitalAdminRepository;

@Service
public class HospitalAdminService {
	
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private HospitalAdminRepository userRepository;

    public void registerUser(HospitalAdminEntity user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public HospitalAdminEntity validateUser(String email, String password) {
    	HospitalAdminEntity user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
    
    public HospitalAdminEntity getUserByEmail(String email) {
    	HospitalAdminEntity user = userRepository.findByEmail(email);
        return user;
    }


}
