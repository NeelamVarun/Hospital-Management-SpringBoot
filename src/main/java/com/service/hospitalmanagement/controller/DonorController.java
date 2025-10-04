package com.service.hospitalmanagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.hospitalmanagement.dto.ApiResponse;
import com.service.hospitalmanagement.dto.DonorDetailWithNotificationResponse;
import com.service.hospitalmanagement.dto.DonorDetailsResponse;
import com.service.hospitalmanagement.dto.DonorNotificationDto;
import com.service.hospitalmanagement.entity.DonorEntity;
import com.service.hospitalmanagement.entity.DonorNotificationEntity;
import com.service.hospitalmanagement.entity.DonorNotificationResponseEntity;
import com.service.hospitalmanagement.service.DonorNotificationResponseService;
import com.service.hospitalmanagement.service.DonorNotificationService;
import com.service.hospitalmanagement.service.DonorUserService;

@RestController
@RequestMapping("/donor")
public class DonorController {

	private static final Logger logger = LoggerFactory.getLogger(DonorController.class);

	@Autowired
	private DonorUserService donorUserService;

	@Autowired
	private DonorNotificationService donorNotificationService;

	@Autowired
	private DonorNotificationResponseService donorNotificationResponseService;

	/**
	 * GET /hospitalAdmin/donars Returns all donor details: name, contact, blood
	 * group, last donated date - hospital screen homepage
	 */
	@GetMapping("/all")
	public ResponseEntity<List<DonorDetailsResponse>> getAllDonars() {
		List<DonorEntity> donors = donorUserService.getAllDonars();
		List<DonorDetailsResponse> list = new ArrayList<>();

		for (DonorEntity donor : donors) {
			DonorNotificationEntity notification = donorNotificationService.findLatestByDonorEmail(donor.getEmail());
			boolean isNotified = false;
			LocalDate notifiedDate = null;
			if (notification != null) {
				isNotified = notification.getHasNotification().equals("Yes") ? true : false;
				notifiedDate = notification.getNotificationDate() != null ? notification.getNotificationDate() : null;
			}
			 DonorDetailsResponse response = new DonorDetailsResponse(
	                    donor.getDonorId(),
	                    donor.getName(),
	                    isNotified,
	                    donor.getContact(),
	                    donor.getBloodGroup(),
	                    donor.getLastDonatedDate(),
	                    notifiedDate,
	                    false); 

	            list.add(response);
		}

		return ResponseEntity.ok(list);
	}

	/**
	 * After donar logins in - dashboard screen homepage- donar
	 */
	@GetMapping("/details")
	public ResponseEntity<DonorDetailsResponse> getDonarDetail(@RequestParam String email) {
		DonorEntity user = donorUserService.getDonarByEmail(email);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		DonorNotificationEntity notification = donorNotificationService.findLatestByDonorId(user.getDonorId());
		boolean isNotified = false;
		LocalDate notifiedDate = null;
		if (notification != null) {
			isNotified = notification.getHasNotification().equals("Yes") ? true : false;
			notifiedDate = notification.getNotificationDate() != null ? notification.getNotificationDate() : null;
		}

		DonorNotificationResponseEntity notificationResponse = donorNotificationResponseService
				.findLatestByDonorId(user.getDonorId());
		boolean hasResponded = false;
		if (notificationResponse != null) {
			hasResponded = true;
		}
		
		if(isNotified) {
			hasResponded = false;
		}

		DonorDetailsResponse response = new DonorDetailsResponse(user.getDonorId(), user.getName(), isNotified,
				user.getContact(), user.getBloodGroup(), user.getLastDonatedDate(), notifiedDate, hasResponded);
		return ResponseEntity.ok(response);
	}

//Hospital screen - notify button- inserts into donar notification table
	@PostMapping("/sendNotification")
	public ResponseEntity<ApiResponse> insertDonarNotification(@RequestBody DonorNotificationDto notificationDto) {
		DonorEntity user = donorUserService.getDonorByDonorId(notificationDto.getDonorId());
		
		DonorNotificationEntity entity = new DonorNotificationEntity();
		entity.setDonorUser(user);
		entity.setDonorName(user.getName());
		entity.setHasNotification("Yes");
		entity.setNotificationDate(LocalDate.now());
		donorNotificationService.saveNotification(entity);
		ApiResponse response = new ApiResponse("success", "Notification sent successfully");
		return ResponseEntity.ok(response);
	}

//Donar screen - response save
	@PostMapping("/addNotificationResponse")
	public ResponseEntity<ApiResponse> insertDonorNotificationResponse(
			@RequestBody DonorNotificationResponseEntity notification) {
		DonorEntity user = donorUserService.getDonarByEmail(notification.getDonorEmail());
		notification.setDonorUser(user);
		donorNotificationResponseService.saveResponse(notification);

		// update hasNotification
		DonorNotificationEntity notificationEntity = donorNotificationService
				.findLatestByDonorId(user.getDonorId());
		notificationEntity.setHasNotification("No");
		donorNotificationService.saveNotification(notificationEntity);

		ApiResponse response = new ApiResponse("success", "Notification response saved successfully");
		return ResponseEntity.ok(response);
	}

//Hospital screen - see donar response.
	@GetMapping("/notificationResponse/{donorId}")
	public ResponseEntity<DonorDetailWithNotificationResponse> getDonarDetailWithNotification(
			@PathVariable("donorId") Long donorId) {
		DonorEntity user = donorUserService.getDonorByDonorId(donorId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		DonorNotificationResponseEntity notification = donorNotificationResponseService.findLatestByDonorId(donorId);
		DonorDetailWithNotificationResponse response = new DonorDetailWithNotificationResponse();
		response.setName(user.getName());
		response.setContact(user.getContact());
		response.setBloodGroup(user.getBloodGroup());

		if (notification != null) {
			response.setVehicleNeed(notification.getNeedsVehicle());
			response.setAvailable(notification.getAvailable());
			response.setAvailableSlot(notification.getTimeSlot());
			response.setResponseDate(notification.getResponseDate());
			response.setLastDonatedDate(notification.getResponseDate());
		} else {
			return ResponseEntity.ok(null);
		}

		return ResponseEntity.ok(response);
	}
}