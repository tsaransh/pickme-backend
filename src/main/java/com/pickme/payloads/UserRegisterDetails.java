package com.pickme.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDetails {

    private String firstName;
    private String middleName;
    private String lastName;

    private String phoneNumber;
    private String emailAddress;

    private String password;

}
