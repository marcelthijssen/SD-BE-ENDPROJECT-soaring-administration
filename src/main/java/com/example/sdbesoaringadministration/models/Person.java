/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Creates an object of Person
 */

package com.example.sdbesoaringadministration.models;

import com.example.sdbesoaringadministration.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Person")
@Table(name = "PERSONS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "membership_id",
            referencedColumnName = "id")
    @JsonManagedReference
    private Membership membership;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name="date_of_birth", columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;

    @Column
    private Boolean pilotLicense;

    @JsonIgnore
    @OneToOne(mappedBy = "person")
    private Address address;

    @OneToMany
            (mappedBy = "captain",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> captain;

    @OneToMany
            (mappedBy = "passenger",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> passenger;

    @OneToMany
            (mappedBy = "billedPerson",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> billedPerson;


    @OneToMany
            (mappedBy = "owner",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plane> owner;


    @OneToMany
            (mappedBy = "technician",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Plane> technician;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( LocalDate dateOfBirth ) {
        this.dateOfBirth = dateOfBirth;
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

    public Boolean getPilotLicense() {
        return pilotLicense;
    }

    public void setPilotLicense( Boolean pilotLicense ) {
        this.pilotLicense = pilotLicense;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress( Address address ) {
        this.address = address;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership( Membership membership ) {
        this.membership = membership;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender( GenderEnum gender ) {
        this.gender = gender;
    }
}
