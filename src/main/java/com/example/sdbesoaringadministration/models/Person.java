package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String gender;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String streetName;
    private String houseNumber;
    private String postalcode;
    private String city;
    private String country;
    private String email;
    private String phone;


    @OneToMany
            (mappedBy = "captain",
                    fetch= FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> captain;

    @OneToMany
            (mappedBy = "passenger",
                    fetch= FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> passenger;

    @OneToMany
            (mappedBy = "owner",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plane> planes;

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

    public void setBirthday( LocalDate dateOfBirth ) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
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

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes( List<Plane> planes ) {
        this.planes = planes;
    }
}
