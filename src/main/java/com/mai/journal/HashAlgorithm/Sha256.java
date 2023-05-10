package com.mai.journal.HashAlgorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component
@Slf4j
public class Sha256 {
    public static char[] getHash(char[] password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = new byte[password.length];

            //ToDo доделать

            byte[] hashedBytes = digest.digest();
        }catch (NoSuchAlgorithmException e){
            log.info("Problem with hash algorithm Sha256");
        }
        return null;
    }
}
