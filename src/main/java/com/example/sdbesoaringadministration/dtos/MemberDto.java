package com.example.sdbesoaringadministration.dtos;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class MemberDto extends PersonDto {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String membership;

    private String pilotLicense;

    private String ownerOfPlane;

    public MemberDto(){}


    public MemberDto( Long id, String gender, String firstName, String lastName, Date dateOfBirth, String streetName, String houseNumber, String postalcode, String city, String country, String email, int phone, String userName, String password, String membership, String pilotLicense, String ownerOfPlane ) {
        super( id, gender, firstName, lastName, dateOfBirth, streetName, houseNumber, postalcode, city, country, email, phone );
        this.userName = userName;
        this.password = password;
        this.membership = membership;
        this.pilotLicense = pilotLicense;
        this.ownerOfPlane = ownerOfPlane;
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
