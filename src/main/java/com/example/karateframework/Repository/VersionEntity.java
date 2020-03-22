package com.example.karateframework.Repository;

import javax.persistence.*;

@Table(name = "Version")
@Entity(name = "Version")
public class VersionEntity {
    @Id
    @Column(name="U_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long U_id;

    private String VersionId;

    public String getVersionId() {
        return VersionId;
    }

    public void setVersionId(String versionId) {
        VersionId = versionId;
    }
}
