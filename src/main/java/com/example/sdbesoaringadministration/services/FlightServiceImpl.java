package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;

    public FlightServiceImpl( FlightRepository repository ) {
        this.repository = repository;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flightList = this.repository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();

        flightList.forEach( f -> flightDtoList.add( new FlightDto( f.getId(), f.getStartTime(), f.getEndTime(), f.getGezagvoerder(), f.getPassenger(), f.isInstructionFlight(), f.getRemarks() ) ) );

        return flightDtoList;
    }

    @Override
    public FlightDto getFlightById( Long id ) {
        FlightDto dto = new FlightDto();
        if ( repository.findById( id ).isPresent() ) {
            Flight f = repository.findById( id ).get();
            dto.setId( f.getId() );
            dto.setStartTime( f.getStartTime() );
            dto.setEndTime( f.getEndTime() );
            dto.setGezagvoerder( f.getGezagvoerder() );
            dto.setPassenger( f.getPassenger() );
            dto.setInstructionFlight( f.isInstructionFlight() );
            dto.setRemarks( f.getRemarks() );
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
        f.setGezagvoerder( flightDto.getGezagvoerder() );
        f.setPassenger( flightDto.getPassenger() );
        f.setInstructionFlight( flightDto.isInstructionFlight() );
        f.setRemarks( flightDto.getRemarks() );

        return this.repository.save( f );
    }

    @Override
    public void deleteFlightById( Long id ) {
        if ( repository.findById( id ).isPresent() ) {
            repository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "No flight found" );
        }
    }

    @Override
    public FlightDto updateFlight( Long id, FlightDto flightDto ) {
        if ( repository.findById( id ).isPresent() ) {
            Flight f = repository.findById( id ).get();
            f.setId( flightDto.getId() );
            f.setStartTime( flightDto.getStartTime() );
            f.setEndTime( flightDto.getEndTime() );
            f.setGezagvoerder( flightDto.getGezagvoerder() );
            f.setPassenger( flightDto.getPassenger() );
            f.setInstructionFlight( flightDto.isInstructionFlight() );
            f.setRemarks( flightDto.getRemarks() );

            repository.save( f );
            return flightDto;
        } else {
            throw new RecordNotFoundException( "Flight not found" );
        }
    }
}
