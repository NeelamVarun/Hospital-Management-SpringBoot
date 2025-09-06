package com.service.hospitalmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotaion.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5174")
public class LoginController{

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest){
        Map<String, Object> response = new HashMap<>();

        if ("admin".equals(loginRequest.getUserName()) && "admin".equals(loginRequest
        .getPassword())){
            response.put("Success", true);
            response.put("message", "Login Successful");
            return ResponseEntity.ok(response);
        }else{
            response.put("success", false);
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}