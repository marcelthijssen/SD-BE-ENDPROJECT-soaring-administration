package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String gender;
    private String fname;
    private String lname;
    private Date doBirth;
    private String streetname;
    private String postalcode;
    private String city;
    private int phone;


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

    public String getFname() {
        return fname;
    }

    public void setFname( String fname ) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname( String lname ) {
        this.lname = lname;
    }

    public Date getDoBirth() {
        return doBirth;
    }

    public void setDobirth( Date dobirth ) {
        this.doBirth = dobirth;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname( String streetname ) {
        this.streetname = streetname;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone( int phone ) {
        this.phone = phone;
    }
}
