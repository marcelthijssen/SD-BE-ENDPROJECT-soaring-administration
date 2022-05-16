package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Membership;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AddressDto {
    @NotBlank(message = "Streetname must be added")
    private String streetName;
    @NotBlank(message = "HouseNumber must be added")
    private String houseNumber;
    private String postalcode;
    @NotBlank(message = "City must be added")
    private String city;
    @NotBlank(message = "Country must be added")
    private String country;

    public AddressDto( Long id,
                      String streetName,
                      String houseNumber,
                      String postalcode,
                      String city,
                      String country
    ) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;

    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName( String streetName ) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber( String houseNumber ) {
        this.houseNumber = houseNumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode( String postalcode ) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }
}