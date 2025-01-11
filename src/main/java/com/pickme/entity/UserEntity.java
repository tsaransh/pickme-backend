package com.pickme.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pick_me_user_details")
public class UserEntity {

    @Id
    private String userId;

    @NotNull(message = "First name can't be empty")
    private String firstName;
    private String middleName;
    private String lastName;

    @NotNull(message = "Phone number can't be empty")
    private String phoneNumber;

    @Email
    private String emailAddress;

    @NotNull(message = "Password can't be empty")
    private String password;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastUpdateDate;

}
