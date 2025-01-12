package com.pickme.entity;

import com.pickme.dto.UserResponseDto;
import com.pickme.entity.tables.UserEntity;
import com.pickme.payloads.UserRegisterDetails;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Mapper {

    public static UserEntity mapToUserEntity(UserRegisterDetails details) {
        return UserEntity.builder()
                .userId(generateUserId())
                .firstName(details.getFirstName())
                .middleName(details.getMiddleName())
                .lastName(details.getLastName())
                .emailAddress(details.getEmailAddress())
                .phoneNumber(details.getPhoneNumber())
                .password(details.getPassword())
                .build();
    }


    private static String generateUserId() {
        return UUID.randomUUID().toString();
    }

    public static UserResponseDto toUserUserDto(UserEntity savedUser) {
        return  UserResponseDto.builder()
                .userId(savedUser.getUserId())
                .fullName(getUserFullName(savedUser.getFirstName(), savedUser.getMiddleName(), savedUser.getLastName()))
                .emailAddress(savedUser.getEmailAddress())
                .phoneNumber(savedUser.getPhoneNumber())
                .lastRides(new ArrayList<>())
                .build();
    }

    private static String getUserFullName(String firstName, String middleName, String lastName) {

        StringBuilder fullName = new StringBuilder(firstName);
        if(!StringUtils.isEmpty(middleName)) {
            fullName.append(" ").append(middleName);
        }
        if(!StringUtils.isEmpty(lastName)) {
            fullName.append(" ").append(lastName);
        }
        return fullName.toString();
    }
}
