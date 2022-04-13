package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;


import javax.persistence.Temporal;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.*;


@Validated
public class PersonDto {

    private Long id;
    private String gender;
    //    @NotBlank(message = "Firstname can not be empty")
    private String firstName;
    //    @NotBlank(message = "Lastname can not be empty")
    private String lastName;
    private java.time.LocalDate LocalDate;
    //    @DateTimeFormat
//    @DateTimeFormat(iso =
    @DateTimeFormat
    private LocalDate birthday;
    private String streetName;
    private String houseNumber;
    private String postalcode;
    private String city;
    private String country;
    @NotBlank(message="Email must be added")
    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;
    private String phone;


    public PersonDto() {
    }

    public PersonDto( Long id, String gender, String firstName, String lastName, LocalDate birthday, String streetName, String houseNumber, String postalcode, String city, String country, String email, String phone ) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {

        return id;
    }



    public static PersonDto personToPersonDto( Person p ) {
        PersonDto dto = new PersonDto();

//        PersonDto.convertToDateViaSqlDate( dto.getBirthday() );

        dto.setId( p.getId() );
        dto.setGender( p.getGender() );
        dto.setFirstName( p.getFirstName() );
        dto.setLastName( p.getLastName() );
        dto.setBirthday( p.getBirthday() );
        dto.setStreetName( p.getStreetName() );
        dto.setHouseNumber( p.getHouseNumber() );
        dto.setPostalcode( p.getPostalcode() );
        dto.setCity( p.getCity() );
        dto.setCountry( p.getCountry() );
        dto.setPhone( p.getPhone() );
        dto.setEmail( p.getEmail() );

        return dto;
    }


    public static Person personDtoToPerson( PersonDto personDto ) {

//        PersonDto.convertToDateViaSqlDate( personDto.getBirthday() );

        Person p = new Person();
        p.setId( personDto.getId() );
        p.setGender( personDto.getGender() );
        p.setFirstName( personDto.getFirstName() );
        p.setLastName( personDto.getLastName() );
        p.setBirthday( personDto.getBirthday() );
        p.setStreetName( personDto.getStreetName() );
        p.setHouseNumber( personDto.getHouseNumber() );
        p.setPostalcode( personDto.getPostalcode() );
        p.setCity( personDto.getCity() );
        p.setCountry( personDto.getCountry() );
        p.setPhone( personDto.getPhone() );
        p.setEmail( personDto.getEmail() );

        return p;
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

    public void setBirthday( LocalDate birthday ) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

//    public static java.util.Date convertToDateViaSqlDate( LocalDate dateToConvert ) {
//        return java.sql.Date.valueOf(dateToConvert);
//    }
//    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
//        return java.sql.Date.valueOf( String.valueOf( dateToConvert ) );
//    }
}
