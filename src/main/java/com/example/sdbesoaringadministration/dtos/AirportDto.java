package com.example.sdbesoaringadministration.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class AirportDto {

    private Long id;

    @Length(min=4, max=4, message = "ICAO notation must have exactly 4 characters")
    private String Icao;

    @NotBlank(message = "Location can not be empty")
    private String location;

    // CONSTRUCTORS
    public AirportDto() {
    }

    public AirportDto( Long id, String ICAO, String location ) {
        this.id = id;
        this.Icao = ICAO;
        this.location = location;
    }

//    GETTERS AND SETTERS
    public String getIcao() {
        return Icao;
    }

    public void setIcao( String icao ) {
        this.Icao = icao;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }
}
