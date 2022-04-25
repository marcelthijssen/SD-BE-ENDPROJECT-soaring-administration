package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.Airport;
//import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

//@Data
@Validated
public class AirportDto {

    private Long id;

    @Length(min = 4, max = 4, message = "ICAO notation must have exactly 4 characters")
    private String Icao;

    @NotBlank(message = "City can not be empty")
    private String city;

    @NotBlank(message = "Country must be added")
    private String country;

    // CONSTRUCTORS
    public AirportDto() {
    }

    public AirportDto( Long id, String ICAO, String city, String country ) {
        this.id = id;
        this.Icao = ICAO;
        this.city = city;
        this.country = country;
    }

    //    Dto to Model
    public static Airport airportDtoToAirport( AirportDto dto ) {
        Airport airport = new Airport();

        airport.setId( dto.getId() );
        airport.setIcao( dto.getIcao() );
        airport.setCity( dto.getCity() );
        airport.setCountry( dto.getCountry() );

        return airport;
    }

    public AirportDto airportToAirportDto( Airport airport ) {
        AirportDto dto = new AirportDto();
        dto.setId( airport.getId() );
        dto.setIcao( airport.getIcao() );
        dto.setCity( airport.getCity() );
        dto.setCountry( airport.getCountry() );
        return dto;
    }

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
}
