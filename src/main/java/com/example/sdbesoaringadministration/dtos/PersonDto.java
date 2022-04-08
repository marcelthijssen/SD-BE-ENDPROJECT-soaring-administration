package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class PersonDto {

    private Long id;
    private String gender;
    //    @NotBlank(message = "Firstname can not be empty")
    private String firstName;
    //    @NotBlank(message = "Lastname can not be empty")
    private String lastName;
    @DateTimeFormat
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    private String streetName;
    private String houseNumber;
    private String postalcode;
    private String city;
    private String country;
    @Email
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


    public static PersonDto personToPersonDto( Person person ) {
        PersonDto personDTO = new PersonDto();

        personDTO.setId( person.getId() );
        personDTO.setGender( person.getGender() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setStreetName( person.getStreetName() );
        personDTO.setHouseNumber( person.getHouseNumber() );
        personDTO.setPostalcode( person.getPostalcode() );
        personDTO.setCity( person.getCity() );
        personDTO.setCountry( person.getCountry() );
        personDTO.setPhone( person.getPhone() );
        personDTO.setEmail( person.getEmail() );

        return personDTO;
    }


    public static Person personDtoToPerson( PersonDto personDto ) {

        Person person = new Person();
        person.setId( personDto.getId() );
        person.setGender( personDto.getGender() );
        person.setFirstName( personDto.getFirstName() );
        person.setLastName( personDto.getLastName() );
        person.setBirthday( personDto.getBirthday() );
        person.setStreetName( personDto.getStreetName() );
        person.setHouseNumber( personDto.getHouseNumber() );
        person.setPostalcode( personDto.getPostalcode() );
        person.setCity( personDto.getCity() );
        person.setCountry( personDto.getCountry() );
        person.setPhone( personDto.getPhone() );
        person.setEmail( personDto.getEmail() );

        return person;
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
}
