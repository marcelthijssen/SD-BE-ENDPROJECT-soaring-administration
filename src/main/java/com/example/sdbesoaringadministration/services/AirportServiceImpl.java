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
        List<Airport> airportList = this.airportRepository.findAll();
        List<AirportDto> airportDtoList = new ArrayList<>();

        for ( Airport ap : airportList ) {
            AirportDto dto = new AirportDto().airportToAirportDto( ap );

            airportDtoList.add( dto );
        }
        return airportDtoList;
    }

    @Override
    public AirportDto getAirportsById( Long id ) {
        if ( airportRepository.findById( id ).isPresent() ) {

            Airport ap = airportRepository.findById( id ).get();
            AirportDto dto = new AirportDto().airportToAirportDto(ap);

            return dto;
        } else {
            throw new RecordNotFoundException();
        }
    }


    @Override
    public Airport createAirport( AirportDto airportDto ) {
        Airport ap = airportDtoToAirport( airportDto );

        return this.airportRepository.save( ap );
    }

    @Override
    public ResponseEntity<Object> deleteAirportById( Long apid ) {
        if ( airportRepository.findById( apid ).isPresent() ) {
            airportRepository.deleteById( apid );
            return new ResponseEntity<>("Airport is deleted", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }


  @Override
    public AirportDto updateAirport( Long apid, AirportDto dto ) {
        if ( airportRepository.findById( apid ).isPresent() ) {
            Airport ap = airportRepository.findById( apid ).get();
            dto.setId( ap.getId() );
            dto.setIcao( ap.getIcao() );
            dto.setCity( ap.getCity() );
            dto.setCountry(ap.getCountry());

            airportRepository.save(ap);
            return dto;
        } else {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }
}
