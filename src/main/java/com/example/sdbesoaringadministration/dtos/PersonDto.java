package com.example.sdbesoaringadministration.dtos;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class PersonDto {

    private Long id;
    private String gender;
    @NotBlank(message = "Firstname can not be empty")
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String streetName;
    private String houseNumber;
    private String postalcode;
    private String city;
    private String country;
    private String email;
    private int phone;

    public PersonDto(){
    }

    public PersonDto( Long id, String gender, String firstName, String lastName, LocalDate birthday, String streetName, String houseNumber, String postalcode,String city, String country, String email, int phone ) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.streetName = streetName;
        this.houseNumber=houseNumber;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
        this.email=email;
        this.phone = phone;
    }

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public void setBirthday( LocalDate doBirth ) {
        this.birthday = birthday;
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

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone( int phone ) {
        this.phone = phone;
    }
}
