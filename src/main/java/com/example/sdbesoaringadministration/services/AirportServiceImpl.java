package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.repositories.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.AirportDto.airportDtoToAirport;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl( AirportRepository airportRepository ) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<AirportDto> getAllAirports() {
        List<Airport> listAirports = this.airportRepository.findAll();
        List<AirportDto> listAirportsDto = new ArrayList<>();

        listAirports.forEach( a -> listAirportsDto.add( new AirportDto( a.getId(), a.getIcao(), a.getLocation() ) ) );
        return listAirportsDto;
    }

    @Override
    public AirportDto getAirportsById( Long id ) {
        AirportDto dto = new AirportDto();
        if ( airportRepository.findById( id ).isPresent() ) {
            Airport airport = airportRepository.findById( id ).get();
            dto.setId( airport.getId() );
            dto.setIcao( airport.getIcao() );
            dto.setLocation( airport.getLocation() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }


    @Override
    public Airport addAirport( AirportDto airportDto ) {
        Airport airport = airportDtoToAirport( airportDto );

        return this.airportRepository.save( airport );
    }

    @Override
    public ResponseEntity<Object> deleteAirportById( Long id ) {
        if ( airportRepository.findById( id ).isPresent() ) {
            airportRepository.deleteById( id );
            return new ResponseEntity<>("Airport is deleted", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }


    @Override
    public AirportDto updateAirport( Long id, AirportDto dto ) {
        if ( airportRepository.findById( id ).isPresent() ) {
            Airport airport = airportRepository.findById( id ).get();
            dto.setId( airport.getId() );
            dto.setIcao( airport.getIcao() );
            dto.setLocation( airport.getLocation() );

            airportRepository.save(airport);
            return dto;
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }

}
