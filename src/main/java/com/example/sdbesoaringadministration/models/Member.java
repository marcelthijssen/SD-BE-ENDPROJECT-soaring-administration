package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "members")
public class Member extends Person {

    private String userName;

    private String password;

    private String membership;

    private String pilotLicense;
    private String ownerOfPlane;



    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership( String membership ) {
        this.membership = membership;
    }

    public String getPilotLicense() {
        return pilotLicense;
    }

    public void setPilotLicense( String pilotLicense ) {
        this.pilotLicense = pilotLicense;
    }

    public String getOwnerOfPlane() {
        return ownerOfPlane;
    }

    public void setOwnerOfPlane( String ownerOfPlane ) {
        this.ownerOfPlane = ownerOfPlane;
    }
}
