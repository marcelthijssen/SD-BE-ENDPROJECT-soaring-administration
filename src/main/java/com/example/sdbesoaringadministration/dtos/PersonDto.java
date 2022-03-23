package com.example.sdbesoaringadministration.dtos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class PersonDto {

    private Long id;
    private String gender;
    private String fname;
    private String lname;
    private Date doBirth;
    private String streetname;
    private String postalcode;
    private String city;
    private int phone;

    public PersonDto(){
    }

    public PersonDto( Long id, String gender, String fname, String lname, Date doBirth, String streetname, String postalcode, String city, int phone ) {
        this.id = id;
        this.gender = gender;
        this.fname = fname;
        this.lname = lname;
        this.doBirth = doBirth;
        this.streetname = streetname;
        this.postalcode = postalcode;
        this.city = city;
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

    public void setDoBirth( Date doBirth ) {
        this.doBirth = doBirth;
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
