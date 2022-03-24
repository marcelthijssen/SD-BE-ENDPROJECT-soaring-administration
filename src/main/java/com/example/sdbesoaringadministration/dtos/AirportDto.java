package com.example.sdbesoaringadministration.dtos;

public class AirportDto {

    private Long id;

    private String Icao;
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
