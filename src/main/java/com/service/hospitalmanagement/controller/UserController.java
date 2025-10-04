package com.service.hospitalmanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.hospitalmanagement.dto.LoginRequest;
import com.service.hospitalmanagement.entity.DonorEntity;
import com.service.hospitalmanagement.entity.HospitalAdminEntity;
import com.service.hospitalmanagement.service.DonorUserService;
import com.service.hospitalmanagement.service.HospitalAdminService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private DonorUserService donorUserService;

	@Autowired
	private HospitalAdminService hospitalUserService;
	
	@PostMapping("/donorLogin")
	public ResponseEntity<Map<String, Object>> donarLogin(@RequestBody LoginRequest loginRequest) {
	    Map<String, Object> response = new HashMap<>();
	    DonorEntity user = donorUserService.validateUser(loginRequest.getUserName(), loginRequest.getPassword());

	    if (user != null) {
	        response.put("success", true);
	        response.put("message", "Login successful");
	        return ResponseEntity.ok(response);
	    } else {
	        response.put("success", false);
	        response.put("message", "Invalid username or password");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}

	@PostMapping("hospitalLogin")
	public ResponseEntity<Map<String, Object>> hospitalLogin(@RequestBody LoginRequest loginRequest) {
		Map<String, Object> response = new HashMap<>();
		HospitalAdminEntity user = hospitalUserService.validateUser(loginRequest.getUserName(),
				loginRequest.getPassword());
		if (user == null) {
			response.put("success", false);
			response.put("message", "Invalid username or password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
		response.put("success", true);
		response.put("data", user);
		return ResponseEntity.ok(response);
	}


	@PostMapping("registerHospitalUser")
	public ResponseEntity<Map<String, Object>> register(@RequestBody HospitalAdminEntity user) {
		Map<String, Object> response = new HashMap<>();
		try {
			HospitalAdminEntity existingUser = hospitalUserService.getUserByEmail(user.getEmail());
			if (existingUser != null) {
				response.put("success", false);
				response.put("message", "Hospital User email already exists");
			}else {
				hospitalUserService.registerUser(user);
				response.put("success", true);
				response.put("message", "Hospital User registered successfully");
			}
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "Registration failed - " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/registerDonorUser")
	public ResponseEntity<Map<String, Object>> registerDonor(@RequestBody DonorEntity user) {
		Map<String, Object> response = new HashMap<>();
		try {
			DonorEntity existingUser = donorUserService.getUserByEmail(user.getEmail());
			if (existingUser != null) {
				response.put("success", false);
				response.put("message", "Donor Email already exists");
			}else {
				donorUserService.registerUser(user);
				response.put("success", true);
				response.put("message", "Donor User registered successfully");
			}
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "Registration failed - " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}