package com.pickme.entity.services;

import com.pickme.dto.UserResponseDto;
import com.pickme.payloads.UserRegisterDetails;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {

    public Optional<UserDetails> loadUserByUsername(String username);

    public UserResponseDto registerUser(UserRegisterDetails details);
    public UserResponseDto getUserDetails(String emailOrPhone);

}
