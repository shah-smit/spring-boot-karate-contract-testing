package com.example.karateframework.Service;

import com.example.karateframework.Repository.VersionEntity;
import com.example.karateframework.Repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private VersionRepository versionRepository;

    public String getName(String name) {
        return getNameFormat(name);
    }

    public void addVersion(String version) {
        VersionEntity v = new VersionEntity();
        v.setVersionId(version);
        this.versionRepository.save(v);
    }

    public String getVersion() {
        return "v1.0";
    }


    private String getNameFormat(String value) {
        String lowercaseValue = value.toLowerCase();
        if (value.length() > 1) {
            StringBuilder stringBuilder = new StringBuilder(lowercaseValue.substring(1));
            return String.valueOf(value.charAt(0)).toUpperCase() + stringBuilder;
        } else {
            return value.toUpperCase();
        }
    }
}
