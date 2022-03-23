package com.example.sdbesoaringadministration.dtos;

public class AirportDto {

    private Long id;
    private String ICAO;
    private String location;

    public AirportDto() {
    }


    public AirportDto( Long id, String ICAO, String location ) {
        this.id = id;
        this.ICAO = ICAO;
        this.location = location;
    }

    public String getICAO() {
        return ICAO;
    }

    public void setICAO( String ICAO ) {
        this.ICAO = ICAO;
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
