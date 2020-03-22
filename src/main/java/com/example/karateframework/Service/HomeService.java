package com.example.karateframework.Service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getName(String name){
        return getNameFormat(name);
    }


    private String getNameFormat(String value){
        String lowercaseValue = value.toLowerCase();
        if(value.length() > 1){
            StringBuilder stringBuilder = new StringBuilder(lowercaseValue.substring(1));
            return String.valueOf(value.charAt(0)).toUpperCase()+stringBuilder;
        }
        else {
            return value.toUpperCase();
        }
    }
}
