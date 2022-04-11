package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.FlightDto.flightDtoToFlight;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flRepository;
    private final PlaneRepository plRepository;
    private final AirportRepository apRepository;
    private final StartingMethodeRepository smRepository;
    private final PersonRepository personRepository;

    public FlightServiceImpl( FlightRepository flRepository, PlaneRepository plRepository, AirportRepository apRepository, StartingMethodeRepository smRepository, PersonRepository personRepository ) {
        this.flRepository = flRepository;
        this.plRepository = plRepository;
        this.apRepository = apRepository;
        this.smRepository = smRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flightList = this.flRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();

        flightList.forEach( fl -> flightDtoList.add( new FlightDto( fl.getId(), fl.getStartTime(), fl.getEndTime(), fl.getInstructionFlight(), fl.getRemarks(), fl.getPlane(), fl.getAirportStart(), fl.getAirportEnd(), fl.getStartingMethode(),
                fl.getPassenger(), fl.getCaptain() ) ) );

        return flightDtoList;
    }


    @Override
    public FlightDto getFlightById( Long id ) {
        if ( flRepository.findById( id ).isPresent() ) {
            Flight flight = flRepository.findById( id ).get();
            return new FlightDto().flightToFlightDto( flight );
        } else {
            throw new RecordNotFoundException();
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
    public FlightDto updateFlight( Long id, FlightDto dto ) {
        if ( flRepository.findById( id ).isPresent() ) {
            Flight fl = flRepository.findById( id ).get();
            fl.setId( fl.getId() );
            fl.setStartTime( dto.getStartTime() );
            fl.setEndTime( dto.getEndTime() );
            fl.setInstructionFlight( dto.getInstructionFlight() );
            fl.setRemarks( dto.getRemarks() );
            fl.setPlane( dto.getPlane() );
            fl.setAirportStart( dto.getAirportStart() );
            fl.setAirportEnd( dto.getAirportEnd() );
            fl.setStartingMethode( dto.getStartingMethode() );
            fl.setPassenger( dto.getPassenger() );
            fl.setCaptain( dto.getCaptain() );

// plane
            fl.setPlane( dto.getPlane() );
            flRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found" );
        }
    }

    @Override
    public void assignPlaneToFlight( Long id, Long plid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalPlane = plRepository.findById( plid );

        if ( optionalFlight.isPresent() && optionalPlane.isPresent() ) {
            var flight = optionalFlight.get();
            var plane = optionalPlane.get();

            flight.setPlane( plane );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Plane or flight doesn't exist" );
        }
    }

    @Override
    public void assignAirportStartToFlight( Long id, Long apid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalAirportStart = apRepository.findById( apid );

        if ( optionalFlight.isPresent() && optionalAirportStart.isPresent() ) {
            var flight = optionalFlight.get();
            var airportStart = optionalAirportStart.get();

            flight.setAirportStart( airportStart );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Airport or flight doesn't exist" );
        }
    }
    @Override
    public void assignAirportEndToFlight( Long id, Long aeid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalAirportEnd = apRepository.findById( aeid );

        if ( optionalFlight.isPresent() && optionalAirportEnd.isPresent() ) {
            var flight = optionalFlight.get();
            var airportEnd = optionalAirportEnd.get();

            flight.setAirportEnd( airportEnd );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Airport or flight doesn't exist" );
        }
    }

    @Override
    public void assignStartingMethodeToFlight( Long id, Long smid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalStartingMethode = smRepository.findById( smid );

        if ( optionalFlight.isPresent() && optionalStartingMethode.isPresent() ) {
            var flight = optionalFlight.get();
            var startingMethode = optionalStartingMethode.get();

            flight.setStartingMethode( startingMethode );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or startingmethode doesn't exist" );
        }
    }

    public void assignPassengerToFlight( Long id, Long psid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalPerson = personRepository.findById( psid );

        if ( optionalFlight.isPresent() && optionalPerson.isPresent() ) {
            var flight = optionalFlight.get();
            var person = optionalPerson.get();

            flight.setPassenger( person );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or person doesn't exist" );
        }
    }

    public void assignCaptainToFlight( Long id, Long cpid ) {
        var optionalFlight = flRepository.findById( id );
        var optionalPerson = personRepository.findById( cpid );

        if ( optionalFlight.isPresent() && optionalPerson.isPresent() ) {
            var flight = optionalFlight.get();
            var person = optionalPerson.get();

            flight.setCaptain( person );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or this person doesn't exist" );
        }
    }

}
