package com.pickme.entity.services.impl;

import com.pickme.dto.UserResponseDto;
import com.pickme.entity.Mapper;
import com.pickme.entity.dao.UserRepository;
import com.pickme.entity.services.UserService;
import com.pickme.entity.tables.UserEntity;
import com.pickme.payloads.UserRegisterDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userDataBase;

    @Override
    public Optional<UserDetails> loadUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public UserResponseDto registerUser(UserRegisterDetails details) {
        UserEntity savedUser = userDataBase.save(Mapper.mapToUserEntity(details));

        return Mapper.toUserUserDto(savedUser);
    }

    @Override
    public UserResponseDto getUserDetails(String emailOrPhone) {
        return null;
    }
}
