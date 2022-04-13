package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Member extends Person {


private Long id;
    private String userName;

    private String password;

    private String membership;

    private String role;

    private String pilotLicense;


//GETTERS en setters
public Long getId() {

    return id;
}

    public void setId( Long id ) {
        this.id = id;
    }

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



    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public String getPilotLicense() {
        return pilotLicense;
    }

    public void setPilotLicense( String pilotLicense ) {
        this.pilotLicense = pilotLicense;
    }

}
