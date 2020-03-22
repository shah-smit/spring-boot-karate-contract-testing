package com.example.karateframework.Controller;

import com.example.karateframework.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String getVersion(){
        return "v1.0";
    }

    @GetMapping("/greeting")
    public String getVersionParam(@RequestParam String name){
        return "Welcome to KarateFramework, "+homeService.getName(name);
    }

    @GetMapping("/greeting/{name}")
    public String getVersion(@PathVariable String name){
        return "Welcome to KarateFramework, "+homeService.getName(name);
    }


}
