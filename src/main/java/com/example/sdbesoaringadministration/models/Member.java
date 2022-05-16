package com.example.sdbesoaringadministration.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Person")
@Table(name = "PERSONS")
public class Member extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Boolean brevet;

    @Column
    private Boolean radioLicense;

    @Column
    private LocalDate lastCheck;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId( Long id ) {
        this.id = id;
    }

    public Boolean getBrevet() {
        return brevet;
    }

    public void setBrevet( Boolean brevet ) {
        this.brevet = brevet;
    }

    public Boolean getRadioLicense() {
        return radioLicense;
    }

    public void setRadioLicense( Boolean radioLicense ) {
        this.radioLicense = radioLicense;
    }

    public LocalDate getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck( LocalDate lastCheck ) {
        this.lastCheck = lastCheck;
    }
}
