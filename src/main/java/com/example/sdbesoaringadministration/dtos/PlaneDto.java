/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Data Transfer Object
 *
 */

package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Person;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Validated
public class PlaneDto {


    private Long id;
    private String callSign;
    @NotBlank(message = "Brand can not be empty")
    private String brand;
    @NotBlank(message = "Type can not be empty")
    private String type;
    @NotBlank(message = "Registration can not be empty")
    private String registration;
    @NotBlank
    private Boolean twoSeater;
    private BigDecimal minutePrice;
    private Boolean privatePlane;
    @NotBlank
    private Person owner;
    private Person technician;
    private byte[] flightStatus;

    public PlaneDto() {
    }

    public PlaneDto( Long id, String callSign, String brand, String type, String registration, Boolean twoSeater, BigDecimal minutePrice, Boolean privatePlane, Person owner, Person technician, byte[] flightStatus ) {
        this.id = id;
        this.callSign = callSign;
        this.brand = brand;
        this.type = type;
        this.registration = registration;
        this.twoSeater = twoSeater;
        this.minutePrice = minutePrice;
        this.privatePlane = privatePlane;
        this.owner = owner;
        this.technician = technician;
        this.flightStatus = flightStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign( String callSign ) {
        this.callSign = callSign;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration( String registration ) {
        this.registration = registration;
    }

    public BigDecimal getMinutePrice() {
        return minutePrice.setScale( 2, RoundingMode.FLOOR );
    }

    public void setMinutePrice( BigDecimal minutePrice ) { this.minutePrice = minutePrice;  }

    public Boolean getTwoSeater() {
        return this.twoSeater;
    }

    public void setTwoSeater( Boolean twoSeater ) {
        this.twoSeater = twoSeater;
    }

    public Boolean getPrivatePlane() {
        return privatePlane;
    }

    public void setPrivatePlane( Boolean privatePlane ) {
        this.privatePlane = privatePlane;
    }

    public byte[] getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus( byte[] flightStatus ) {
        this.flightStatus = flightStatus;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner( Person owner ) {
        this.owner = owner;
    }

    public Person getTechnician() {
        return technician;
    }

    public void setTechnician( Person technician ) {
        this.technician = technician;
    }


}
