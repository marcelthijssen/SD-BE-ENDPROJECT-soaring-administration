package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AirportDto;
import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.AirportDto.airportDtoToAirport;
import static com.example.sdbesoaringadministration.dtos.FlightDto.flightDtoToFlight;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flRepository;
    private final PlaneRepository plRepository;

    public FlightServiceImpl( FlightRepository flRepository, PlaneRepository plRepository ) {
        this.flRepository = flRepository;
        this.plRepository = plRepository;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flightList = this.flRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();

        flightList.forEach( f -> flightDtoList.add( new FlightDto( f.getId(), f.getStartTime(), f.getEndTime(), f.getCaptain(), f.getPassenger(), f.isInstructionFlight(), f.getRemarks(), f.getPlane() ) ) );

        return flightDtoList;
    }

    @Override
    public FlightDto getFlightById( Long id ) {
        FlightDto dto = new FlightDto();
        if ( flRepository.findById( id ).isPresent() ) {
            Flight f = flRepository.findById( id ).get();
            dto.setId( f.getId() );
            dto.setStartTime( f.getStartTime() );
            dto.setEndTime( f.getEndTime() );
            dto.setCaptain( f.getCaptain() );
            dto.setPassenger( f.getPassenger() );
            dto.setInstructionFlight( f.isInstructionFlight() );
            dto.setRemarks( f.getRemarks() );
//            flights
            dto.setPlane( f.getPlane());
            return dto;
        } else {
            throw new RecordNotFoundException( "No flight found" );
        }
    }


    @Override
    public Flight addFlight( FlightDto flightDto ) {
        Flight flight = flightDtoToFlight( flightDto );

        return this.flRepository.save( flight );
    }

    @Override
    public void deleteFlightById( Long id ) {
        if ( flRepository.findById( id ).isPresent() ) {
            flRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "No flight found" );
        }
    }

    @Override
    public FlightDto updateFlight( Long id, FlightDto flightDto ) {
        if ( flRepository.findById( id ).isPresent() ) {
            Flight fl = flRepository.findById( id ).get();
            fl.setId( flightDto.getId() );
            fl.setStartTime( flightDto.getStartTime() );
            fl.setEndTime( flightDto.getEndTime() );
            fl.setCaptain( flightDto.getCaptain() );
            fl.setPassenger( flightDto.getPassenger() );
            fl.setInstructionFlight( flightDto.isInstructionFlight() );
            fl.setRemarks( flightDto.getRemarks() );
// plane
            fl.setPlane( flightDto.getPlane() );
            flRepository.save( fl );
            return flightDto;
        } else {
            throw new RecordNotFoundException( "Flight not found" );
        }
    }

    @Override
    public void assignPlaneToFlight( Long id, Long pid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalPlane = plRepository.findById( pid );

        if ( optionalFlight.isPresent() && optionalPlane.isPresent() ) {
            var flight = optionalFlight.get();
            var plane = optionalPlane.get();

            flight.setPlane( plane );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "tv of rc bestaat niet" );
        }
    }
}
