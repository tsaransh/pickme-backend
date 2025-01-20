package com.pickme.configuration;

import com.pickme.dto.UserResponseDto;
import com.pickme.entity.services.UserService;
import com.pickme.entity.tables.UserEntity;
import com.pickme.exceptions.UserException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class ThreadContentUtils {

    private static String userID = "userID";
    private static String email = "email";
    private static String mobile = "mobile";
    private static String deviceId = "deviceId";
    private static String deviceModel = "deviceModel";
    private static boolean ios = false;
    private static String authToken = "authToken";
    private static int aapOpeningCount = 0;
    private static int otpGeneratorCount = 0;
    private static int failOptEnter = 0;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void init(HttpServletRequest request, String token) {
        if (request != null) {
            userID = request.getHeader(userID);
            email = request.getHeader(email);
            mobile = request.getHeader(mobile);
            deviceId = request.getHeader(deviceId);
            deviceModel = request.getHeader(deviceModel);
            authToken = token;
            ios = "iOS".equalsIgnoreCase(deviceModel);
        }
    }

    public static void increaseAppOpeningCount() {
        aapOpeningCount++;
    }
    public static void increaseOtpGenerateCount() {
        if(failOptEnter >= 3) {
            resetOptCount(60);
            throw new UserException("Please try again after 1 hour", HttpStatus.BAD_REQUEST);
        }
        if(otpGeneratorCount >= 4) {
            resetOptCount(30);
            failOptEnter++;
            throw new UserException("Please try again after 30 Min.", HttpStatus.BAD_REQUEST);
        }
        otpGeneratorCount++;
    }

    private static void resetOptCount(int minutes) {
        scheduler.scheduleAtFixedRate(() -> aapOpeningCount = 0, 0, minutes, TimeUnit.MINUTES);
    }
}
