package com.pickme.controller.auth;

import com.pickme.payloads.UserCredentials;
import com.pickme.payloads.UserRegisterDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/user")
public class UserAuthController {

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserCredentials credentials) {
       return new ResponseEntity<>("Login", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDetails registerDetails) {
        return new ResponseEntity<>("User Registered", HttpStatus.CREATED);
    }

}
