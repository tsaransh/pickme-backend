package com.pickme.payloads;

import lombok.Getter;

public class UserCredentials {
    String phoneOrEmail;
    String password;

    public String getPhoneOrEmail() {
        return phoneOrEmail;
    }

    public String getPassword() {
        return password;
    }
}
