package com.pickme.dto;

import com.pickme.entity.tables.RidesDeatilsEntity;
import lombok.Builder;

import java.util.List;

@Builder
public class UserResponseDto {

    private String userId;
    private String fullName;

    private String emailAddress;
    private String phoneNumber;

    private List<RidesDeatilsEntity> lastRides;

}
