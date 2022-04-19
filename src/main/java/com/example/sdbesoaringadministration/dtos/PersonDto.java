package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Person;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.*;


@Validated
public class PersonDto {

    private Long id;
    private String gender;
        @NotBlank(message = "Firstname can not be empty")
    private String firstName;
        @NotBlank(message = "Lastname can not be empty")
    private String lastName;

    private LocalDate dateOfBirth;
    private String streetName;
    private String houseNumber;
    private String postalcode;
    private String city;
    private String country;
    @NotBlank(message = "Email must be added")
    @Email(message = "Email is not valid", regexp = "(?:[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[A-Za-z0-9-]*[A-Za-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;
    private String phone;

    private String userName;

    private String password;

    private String membership;

    private String role;

    private String pilotLicense;

    public PersonDto() {
    }

    public PersonDto( Long id, String gender, String firstName, String lastName, LocalDate dateOfBirth, String streetName, String houseNumber, String postalcode, String city, String country, String email, String phone,
                      String userName, String password, String membership, String role, String pilotLicense ) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.membership = membership;
        this.role = role;
        this.pilotLicense = pilotLicense;
    }

    public Long getId() {

        return id;
    }


    public static PersonDto personToPersonDto( Person p ) {
        PersonDto dto = new PersonDto();

        dto.setId( p.getId() );
        dto.setGender( p.getGender() );
        dto.setFirstName( p.getFirstName() );
        dto.setLastName( p.getLastName() );
        dto.setDateOfBirth( p.getDateOfBirth() );
        dto.setStreetName( p.getStreetName() );
        dto.setHouseNumber( p.getHouseNumber() );
        dto.setPostalcode( p.getPostalcode() );
        dto.setCity( p.getCity() );
        dto.setCountry( p.getCountry() );
        dto.setEmail( p.getEmail() );
        dto.setPhone( p.getPhone() );
        dto.setUserName( p.getUserName() );
        dto.setPhone( p.getPassword() );
        dto.setMembership( p.getMembership() );
        dto.setRole( p.getRole() );
        dto.setPilotLicense( p.getPilotLicense() );

        return dto;
    }


    public static Person personDtoToPerson( PersonDto dto ) {

        Person p = new Person();
        p.setId( dto.getId() );
        p.setGender( dto.getGender() );
        p.setFirstName( dto.getFirstName() );
        p.setLastName( dto.getLastName() );
        p.setDateOfBirth( dto.getDateOfBirth() );
        p.setStreetName( dto.getStreetName() );
        p.setHouseNumber( dto.getHouseNumber() );
        p.setPostalcode( dto.getPostalcode() );
        p.setCity( dto.getCity() );
        p.setCountry( dto.getCountry() );
        p.setEmail( dto.getEmail() );
        p.setPhone( dto.getPhone() );
        p.setUserName( dto.getUserName() );
        p.setPhone( dto.getPassword() );
        p.setMembership( dto.getMembership() );
        p.setRole( dto.getRole() );
        p.setPilotLicense( dto.getPilotLicense() );
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

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( LocalDate dateOfBirth ) {
        this.dateOfBirth = dateOfBirth;
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
//    public Set<Plane> getplanes() {
//        return planes;
//    }

//    public static java.util.Date convertToDateViaSqlDate( LocalDate dateToConvert ) {
//        return java.sql.Date.valueOf(dateToConvert);
//    }
//    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
//        return java.sql.Date.valueOf( String.valueOf( dateToConvert ) );
//    }
}
