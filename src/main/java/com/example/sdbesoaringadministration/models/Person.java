package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String gender;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String streetName;
    private String houseNumber;
    private String postalcode;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String pilotLicense;
    private String username;
    private String password;
    //    private String role;
    private boolean enabled;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "membership_id",
            referencedColumnName = "id")
    @JsonManagedReference
    private Membership membership;


    @ManyToMany
    @JoinTable(
            name = "persons_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Role> roles = new HashSet<>();


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

    public String getPilotLicense() {
        return pilotLicense;
    }

    public void setPilotLicense( String pilotLicense ) {
        this.pilotLicense = pilotLicense;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership( Membership membership ) {
        this.membership = membership;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }


    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles( Set<Role> roles ) {
    }
//    public void setRoles(Set<Role> roles) {
//        this.roles=roles;
//    }
}
