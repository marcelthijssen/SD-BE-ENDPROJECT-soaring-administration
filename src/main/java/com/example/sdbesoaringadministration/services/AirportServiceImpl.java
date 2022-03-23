package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.repositories.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository repos;

    public AirportServiceImpl( AirportRepository repos ) {
        this.repos = repos;
    }

    @Override
    public List<AirportDto> getAllAirports() {
        List<Airport> listAirports = this.repos.findAll();
        List<AirportDto> listAirportsDto = new ArrayList<>();

        listAirports.forEach( a -> listAirportsDto.add( new AirportDto( a.getId(), a.getICAO(), a.getLocation() ) ) );
        return listAirportsDto;
    }

    @Override
    public AirportDto getAirportsById( Long id ) {
        AirportDto dto = new AirportDto();
        if ( repos.findById( id ).isPresent() ) {
            Airport airport = repos.findById( id ).get();
            dto.setId( airport.getId() );
            dto.setICAO( airport.getICAO() );
            dto.setLocation( airport.getLocation() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }

    @Override
    public Airport addAirport( AirportDto airportDto ) {
        Airport airport = new Airport();
        airport.setId( airportDto.getId() );
        airport.setICAO( airportDto.getICAO() );
        airport.setLocation( airportDto.getLocation() );

        return this.repos.save( airport );
    }

    @Override
    public void deleteAirportById( Long id ) {
//        AirportDto dto = new AirportDto();
        if ( repos.findById( id ).isPresent() ) {
            repos.deleteById( id );
//            return new ResponseEntity("Airport is deleted", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }


    @Override
    public AirportDto updateAirport( Long id, AirportDto dto ) {
        if ( repos.findById( id ).isPresent() ) {
            Airport airport = repos.findById( id ).get();
            dto.setId( airport.getId() );
            dto.setICAO( airport.getICAO() );
            dto.setLocation( airport.getLocation() );

            repos.save(airport);
            return dto;
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }

}
