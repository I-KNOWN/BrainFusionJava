package com.example.brainfusion.utils;

import java.util.Random;


//---------------------------
//NOt Working Currently
//---------------------------
public class WebKitGenerator {

    private String generateRandomString(int length) {

        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero");
        }

        Random random = new Random();
        int[] codeUnits = new int[length];
        for (int i = 0; i < length; i++) {
            codeUnits[i] = random.nextInt(26) + 97;
        }
        return new String(codeUnits, 0, length);
    }

    public String generateBoundaryString() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomString = generateRandomString(16);
        return "---------------------------" + timestamp + "1231597987";
    }

}
