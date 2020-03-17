package com.example.karateframework.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getVersion(){
        return "v1.0";
    }

    @GetMapping("/greeting/{name}")
    public String getVersion(@PathVariable String name){
        return "Welcome to KarateFramework, "+getNameFormat(name);
    }

    @GetMapping("/greeting")
    public String getVersionParam(@RequestParam String name){
        return "Welcome to KarateFramework, "+getNameFormat(name);
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
