package com.example.karateframework.Controller;

import com.example.karateframework.DTO.VersionDTO;
import com.example.karateframework.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String getVersion(){
        return homeService.getVersion();
    }

    @GetMapping("/withHeaders")

    public String getVersionWithHeaders(@RequestHeader(required = false) String apiVersion, @RequestHeader(required = false) String device){
        if(isPresent(apiVersion) && isPresent(device)){
            return "Headers" + homeService.getVersion();
        }
        else {
            return homeService.getVersion();
        }
    }

    @GetMapping("/greeting")
    public String getVersionParam(@RequestParam String name){
        return "Welcome to KarateFramework, "+homeService.getName(name);
    }

    @GetMapping("/greeting/{name}")
    public String getVersion(@PathVariable String name){
        return "Welcome to KarateFramework, "+homeService.getName(name);
    }

    @PostMapping("/")
    public void addVersion(@RequestBody VersionDTO versionDTO){
        homeService.addVersion(versionDTO.getVersion());
    }

    private boolean isPresent(String value){
        return value != null && !value.isEmpty() && !value.trim().isEmpty();
    }

}
