package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Airport;
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

//    Dto to Model
    public static Airport airportDtoToAirport( AirportDto airportDto) {
        Airport airport = new Airport();

        airport.setId( airportDto.getId() );
        airport.setIcao( airportDto.getIcao() );
        airport.setLocation( airportDto.getLocation() );

        return airport;
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
