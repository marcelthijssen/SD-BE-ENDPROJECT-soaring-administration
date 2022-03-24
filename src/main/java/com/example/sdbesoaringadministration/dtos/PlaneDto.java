package com.example.sdbesoaringadministration.dtos;

public class PlaneDto {

    private Long id;

    private String callSign;

    private String brand;

    private String type;

    private String registration;

    private boolean twoSeater;

    private boolean privatePlane;

    public PlaneDto() {
    }

    public PlaneDto( Long id, String callSign, String brand, String type, String registration, boolean twoSeater, boolean privatePlane ) {
        this.id = id;
        this.callSign = callSign;
        this.brand = brand;
        this.type = type;
        this.registration = registration;
        this.twoSeater = twoSeater;
        this.privatePlane = privatePlane;
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

    public boolean isTwoSeater( boolean twoSeater ) {
        return this.twoSeater;
    }

    public void setTwoSeater( boolean twoSeater ) {
        this.twoSeater = twoSeater;
    }

    public boolean isPrivatePlane() {
        return privatePlane;
    }

    public void setPrivatePlane( boolean privatePlane ) {
        this.privatePlane = privatePlane;
    }
}
