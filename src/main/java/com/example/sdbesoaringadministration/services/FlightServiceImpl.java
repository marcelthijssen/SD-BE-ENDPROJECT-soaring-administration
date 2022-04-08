package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Flight f = new Flight();
        f.setId( flightDto.getId() );
        f.setStartTime( flightDto.getStartTime() );
        f.setEndTime( flightDto.getEndTime() );
        f.setCaptain( flightDto.getCaptain() );
        f.setPassenger( flightDto.getPassenger() );
        f.setInstructionFlight( flightDto.isInstructionFlight() );
        f.setRemarks( flightDto.getRemarks() );
//plane
        f.setPlane( flightDto.getPlane() );
        return this.flRepository.save( f );
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
            Flight f = flRepository.findById( id ).get();
            f.setId( flightDto.getId() );
            f.setStartTime( flightDto.getStartTime() );
            f.setEndTime( flightDto.getEndTime() );
            f.setCaptain( flightDto.getCaptain() );
            f.setPassenger( flightDto.getPassenger() );
            f.setInstructionFlight( flightDto.isInstructionFlight() );
            f.setRemarks( flightDto.getRemarks() );
// plane
            f.setPlane( flightDto.getPlane() );
            flRepository.save( f );
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
