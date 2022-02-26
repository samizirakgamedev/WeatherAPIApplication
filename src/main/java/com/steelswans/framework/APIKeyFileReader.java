package com.steelswans.framework;

import java.io.BufferedReader;
import java.io.IOException;


public class APIKeyFileReader {
    public static String readAPIKeyFile(String filePath){
        String line;
        String apiKey;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));) {
            if ((line = reader.readLine()) != null) {
                apiKey = line;
                return apiKey;
            }else {
                System.out.println("Blank file provided");
            }
        }catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
