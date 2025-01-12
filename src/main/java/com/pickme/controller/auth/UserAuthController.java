package com.pickme.controller.auth;

import com.pickme.payloads.UserCredentials;
import com.pickme.payloads.UserRegisterDetails;
import com.pickme.security.JwtTokenGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/user")
@Slf4j
public class UserAuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator tokenGenerator;

    public UserAuthController(AuthenticationManager authenticationManager, JwtTokenGenerator tokenGenerator) {
        this.authenticationManager = authenticationManager;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserCredentials credentials) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getPhoneOrEmail(), credentials.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenGenerator.createToken(authentication);
       return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDetails registerDetails) {
        return new ResponseEntity<>("User Registered", HttpStatus.CREATED);
    }

}
