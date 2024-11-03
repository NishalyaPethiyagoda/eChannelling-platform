package com.authentication_authorization.Login.Utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class PasswordUtils {

    // Method to generate password hash with salt
    public static String generatePasswordHash(String password, String salt) {
        String passwordWithSalt = password + salt;
        return DigestUtils.sha256Hex(passwordWithSalt); // Using SHA-256 hashing algorithm
    }

    // Method to generate a random salt
    public static String generateRandomSalt() {
        return DigestUtils.sha256Hex(UUID.randomUUID().toString());
    }
}
