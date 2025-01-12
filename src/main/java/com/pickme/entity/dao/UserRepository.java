package com.pickme.entity.dao;

import com.pickme.entity.tables.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmailAddressAndPhoneNumber(String emailAddress, String phoneNumber);
}
