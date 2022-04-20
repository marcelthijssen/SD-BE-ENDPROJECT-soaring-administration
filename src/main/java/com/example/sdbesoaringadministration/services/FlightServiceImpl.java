package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flRepository;
    private final PlaneRepository plRepository;
    private final AirportRepository apRepository;
    private final StartingMethodeRepository smRepository;
    private final PersonRepository psRepository;

    public FlightServiceImpl( FlightRepository flRepository, PlaneRepository plRepository, AirportRepository apRepository, StartingMethodeRepository smRepository, PersonRepository psRepository ) {
        this.flRepository = flRepository;
        this.plRepository = plRepository;
        this.apRepository = apRepository;
        this.smRepository = smRepository;
        this.psRepository = psRepository;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flightList = this.flRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();

        for ( Flight fl : flightList ) {
            FlightDto dto = new FlightDto().flightToFlightDto( fl );

            flightDtoList.add( dto );
        }
        return flightDtoList;
    }

    @Override
    public FlightDto getFlightById( Long flid ) {
        if ( flRepository.findById( flid ).isPresent() ) {
            Flight flight = flRepository.findById( flid ).get();
            return new FlightDto().flightToFlightDto( flight );
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public FlightDto addFlight(  ) {
        Flight flight = new Flight();
        this.flRepository.save( flight );

        FlightDto dto = new FlightDto().flightToFlightDto( flight );
        dto.setId( flight.getId() );
        return dto;
    }

    @Override
    public void deleteFlightById( Long flid ) {
        if ( flRepository.findById( flid ).isPresent() ) {
            flRepository.deleteById( flid );
        } else {
            throw new RecordNotFoundException( "No flight found" );
        }
    }

    @Override
    public FlightDto updateFlight( Long flid, FlightDto dto ) {
        if ( flRepository.findById( flid ).isPresent() ) {
            Flight fl = flRepository.findById( flid ).get();
            fl.setId( fl.getId() );
            fl.setTimeStart( dto.getTimeStart() );
            fl.setTimeEnd( dto.getTimeEnd() );
            fl.setTimeFlown( dto.getTimeFlown() );
            fl.setInstructionFlight( dto.getInstructionFlight() );
            fl.setRemarks( dto.getRemarks() );
            fl.setPlane( dto.getPlane() );
            fl.setAirportStart( dto.getAirportStart() );
            fl.setAirportEnd( dto.getAirportEnd() );
            fl.setStartingMethode( dto.getStartingMethode() );
            fl.setPassenger( dto.getPassenger() );
            fl.setCaptain( dto.getCaptain() );
            fl.setBilledPerson(dto.getBilledPerson());

// plane
            fl.setPlane( dto.getPlane() );
            flRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found" );
        }
    }

    @Override
    public void assignPlaneToFlight( Long flid, Long plid ) {
        var optionalFlight = flRepository.findById( flid );
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
    public void assignAirportStartToFlight( Long flid, Long apid ) {
        var optionalFlight = flRepository.findById( flid );
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
    public void assignAirportEndToFlight( Long flid, Long aeid ) {
        var optionalFlight = flRepository.findById( flid );
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
    public void assignStartingMethodeToFlight( Long flid, Long smid ) {
        var optionalFlight = flRepository.findById( flid );
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

    public void assignPassengerToFlight( Long flid, Long psid ) {
        var optionalFlight = flRepository.findById( flid );
        var optionalPerson = psRepository.findById( psid );

        if ( optionalFlight.isPresent() && optionalPerson.isPresent() ) {
            var flight = optionalFlight.get();
            var person = optionalPerson.get();

            flight.setPassenger( person );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or person doesn't exist" );
        }
    }

    public void assignCaptainToFlight( Long flid, Long cpid ) {
        var optionalFlight = flRepository.findById( flid );
        var optionalPerson = psRepository.findById( cpid );

        if ( optionalFlight.isPresent() && optionalPerson.isPresent() ) {
            var flight = optionalFlight.get();
            var person = optionalPerson.get();

            flight.setCaptain( person );
            flRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or this person doesn't exist" );
        }
    }

    public FlightDto assignInstructionFlightToFlight( Long flid, FlightDto dto ) {
        if ( flRepository.findById( flid ).isPresent() ) {
            Flight fl = flRepository.findById( flid ).get();
            fl.setInstructionFlight( dto.getInstructionFlight() );

            flRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found" );
        }
    }
    public void assignTimeStart( Long flid ) {
        var optionalFlight = flRepository.findById( flid );
        var flight = optionalFlight.get();
        flight.setTimeStart( ( LocalDateTime.now() ) );
        flRepository.save( flight );
    }

    public void assignTimeEnd( Long flid ) {
        var optionalFlight = flRepository.findById( flid );
        var flight = optionalFlight.get();
        flight.setTimeEnd( ( LocalDateTime.now() ) );
        flight.setTimeFlown( ChronoUnit.MINUTES.between( flight.getTimeStart(), flight.getTimeEnd() ) );

        if ( !flight.getInstructionFlight() ) {
            flight.setBilledPerson( flight.getCaptain() );
        } else {
            flight.setBilledPerson( flight.getPassenger() );
        }
        flRepository.save( flight );
    }

      @Override
    public FlightDto updateRemarksToFLight( Long flid, FlightDto dto ) {
        if ( flRepository.findById( flid ).isPresent() ) {
            Flight fl = flRepository.findById( flid ).get();
            fl.setRemarks( dto.getRemarks() );

            flRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found" );
        }
    }

    @Override
    public List<FlightDto> getFlightsByCaptain_id( Long cpid ) {
//        Person captain = new Person();
//        if ( !flRepository.findFlightsByCaptainEquals(pid).isEmpty() ) {
        List<Flight> flightList = flRepository.findFlightsByCaptain_Id(cpid );
        List<FlightDto> flightDtoList = new ArrayList<>();

        for ( Flight fl : flightList ) {
            FlightDto dto = new FlightDto().flightToFlightDto( fl );

            flightDtoList.add( dto );
        }
        return flightDtoList;
//        } else {
//            throw new RecordNotFoundException();
//        }
    }


}
