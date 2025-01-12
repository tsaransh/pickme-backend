package com.pickme.security;


import com.pickme.entity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class JwtAuthenticationFilter {

    @Autowired
    private JwtTokenGenerator tokenGenerator;

    @Autowired
    private UserService userService;


}
