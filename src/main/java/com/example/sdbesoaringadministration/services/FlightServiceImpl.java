/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Implements methodes for FlightController
 *
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Invoice;
import com.example.sdbesoaringadministration.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;
    private final StartingMethodeRepository startingMethodeRepository;
    private final PersonRepository personRepository;
    private final InvoiceRepository invoiceRepository;

    public FlightServiceImpl( FlightRepository flightRepository, PlaneRepository planeRepository, AirportRepository airportRepository, StartingMethodeRepository startingMethodeRepository, PersonRepository personRepository, InvoiceRepository invoiceRepository ) {
        this.flightRepository = flightRepository;
        this.planeRepository = planeRepository;
        this.airportRepository = airportRepository;
        this.startingMethodeRepository = startingMethodeRepository;
        this.personRepository = personRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flightList = this.flightRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();

        for ( Flight fl : flightList ) {
            FlightDto dto = flightToFlightDto( fl );
            flightDtoList.add( dto );
        }
        return flightDtoList;
    }

    @Override
    public FlightDto getFlightById( Long flightId ) {
        if ( flightRepository.findById( flightId ).isPresent() ) {
            Flight flight = flightRepository.findById( flightId ).get();
            return flightToFlightDto( flight );
        } else {
            throw new RecordNotFoundException( "Flight not available", HttpStatus.NOT_FOUND );
        }
    }

   public Flight createFlight( FlightDto dto ) {
        Flight fl = new Flight();

        fl.setId( dto.getId() );

        flightRepository.save( fl );
        return fl;
    }

    @Override
    public void deleteFlightById( Long flightId ) {
        if ( flightRepository.findById( flightId ).isPresent() ) {
            flightRepository.deleteById( flightId );
        } else {
            throw new RecordNotFoundException( "No flight found", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public FlightDto updateFlight( Long flightId, FlightDto dto ) {
        if ( flightRepository.findById( flightId ).isPresent() ) {
            Flight fl = flightRepository.findById( flightId ).get();

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
            fl.setBilledPerson( dto.getBilledPerson() );
            fl.setPlane( dto.getPlane() );
            flightRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void assignPlaneToFlight( Long flightId, Long planeId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalPlane = planeRepository.findById( planeId );

        if ( optionalFlight.isPresent() && optionalPlane.isPresent() ) {
            var flight = optionalFlight.get();
            var plane = optionalPlane.get();

            flight.setPlane( plane );
            flightRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Plane or flight doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void assignAirportStartToFlight( Long flightId, Long apersonId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalAirportStart = airportRepository.findById( apersonId );

        if ( optionalFlight.isPresent() && optionalAirportStart.isPresent() ) {
            var flight = optionalFlight.get();
            var airportStart = optionalAirportStart.get();

            flight.setAirportStart( airportStart );
            flightRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Airport or flight doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void assignAirportEndToFlight( Long flightId, Long airportEndId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalAirportEnd = airportRepository.findById( airportEndId );

        if ( optionalFlight.isPresent() && optionalAirportEnd.isPresent() ) {
            var flight = optionalFlight.get();
            var airportEnd = optionalAirportEnd.get();

            flight.setAirportEnd( airportEnd );
            flightRepository.save( flight );

        } else {
            throw new RecordNotFoundException( "Airport or flight doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void assignStartingMethodeToFlight( Long flightId, Long startingMethodeId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalStartingMethode = startingMethodeRepository.findById( startingMethodeId );

        if ( optionalFlight.isPresent() && optionalStartingMethode.isPresent() ) {
            var flight = optionalFlight.get();
            var startingMethode = optionalStartingMethode.get();

            flight.setStartingMethode( startingMethode );
            flightRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or startingmethode doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    public void assignCaptainToFlight( Long flightId, Long captainId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalPerson = personRepository.findById( captainId );

        if ( optionalFlight.isPresent() && optionalPerson.isPresent() ) {
            var flight = optionalFlight.get();
            var person = optionalPerson.get();

            flight.setCaptain( person );
            flightRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or this person doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    public void assignPassengerToFlight( Long flightId, Long psid ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalPerson = personRepository.findById( psid );

        if ( optionalFlight.get().getPlane().getTwoSeater() ) {
            if ( optionalPerson.isPresent() ) {
                var flight = optionalFlight.get();
                var person = optionalPerson.get();

                flight.setPassenger( person );
                flightRepository.save( flight );
            } else {
                throw new RecordNotFoundException( "Invalid person-id", HttpStatus.NOT_FOUND );
            }
        } else {
            new ResponseEntity<>( "plane is a oneseater", HttpStatus.FORBIDDEN );
            return;
        }
        new ResponseEntity<>( "id is added", HttpStatus.CREATED );
    }


    public FlightDto assignInstructionFlightToFlight( Long flightId, FlightDto dto ) {
        if ( flightRepository.findById( flightId ).isPresent() ) {
            Flight fl = flightRepository.findById( flightId ).get();
            fl.setInstructionFlight( dto.getInstructionFlight() );

            flightRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found", HttpStatus.NOT_FOUND );
        }
    }

    public void assignTimeStart( Long flightId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var flight = optionalFlight.get();
        flight.setTimeStart( ( LocalDateTime.now() ) );
        flightRepository.save( flight );
    }

    public void assignTimeEnd( Long flightId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var flight = optionalFlight.get();
        flight.setTimeEnd( ( LocalDateTime.now() ) );
        flight.setTimeFlown( calculateTimeFlown( flight.getTimeStart(), flight.getTimeEnd() ) ); // calculating adding timeFlown

        if ( !flight.getInstructionFlight() ) {
            flight.setBilledPerson( flight.getCaptain() );
        } else {
            flight.setBilledPerson( flight.getPassenger() );
        }
        flightRepository.save( flight );
    }

    @Override
    public FlightDto updateRemarksToFLight( Long flightId, FlightDto dto ) {
        if ( flightRepository.findById( flightId ).isPresent() ) {
            Flight fl = flightRepository.findById( flightId ).get();
            fl.setRemarks( dto.getRemarks() );

            flightRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public List<FlightDto> getFlightsByCaptain_id( Long captainId ) {
        try {
            List<Flight> flightList = flightRepository.findFlightsByCaptain_Id( captainId );
            List<FlightDto> flightDtoList = new ArrayList<>();

            for ( Flight fl : flightList ) {
                FlightDto dto = flightToFlightDto( fl );

                flightDtoList.add( dto );
            }
            return flightDtoList;
        } catch ( Exception e ) {
            throw new RecordNotFoundException( "Nothing found", HttpStatus.NOT_FOUND );
        }
    }

    public ResponseEntity<String> createInvoiceFromFLight( Long flightId ) {
        var optionalFlight = flightRepository.findById( flightId );
        var optionalInvoice = invoiceRepository.findById( flightId );
        var flight = optionalFlight.get();

        if ( optionalInvoice.get().getId().equals( optionalFlight.get().getId() ) ) {
            var invoice = optionalInvoice.get();

        invoice.setId( flight.getId() );
            invoice.setCreationDate( ( LocalDate.now() ) );
            invoice.setBilledPerson( flight.getBilledPerson() );
            invoice.setAmount( calculateCostsOfFlight( flight ) );
            invoice.setId( flight.getId() );
            invoice.setFlight( flight );
            invoiceRepository.save( invoice );

        } else {
            Invoice invoice = new Invoice();
            invoice.setId( flight.getId() );
            invoice.setCreationDate( ( LocalDate.now() ) );
            invoice.setBilledPerson( flight.getBilledPerson() );
            invoice.setAmount( calculateCostsOfFlight( flight ) );
            invoice.setId( flight.getId() );
            invoice.setFlight( flight );
            invoiceRepository.save( invoice );

            return new ResponseEntity<>( "invoice created", HttpStatus.CREATED );
        }
        return new ResponseEntity<>( HttpStatus.OK );
    }


    public long calculateTimeFlown( LocalDateTime timeStart, LocalDateTime timeEnd ) {
        return ( ChronoUnit.MINUTES.between( timeStart, timeEnd ) );
    }

    public BigDecimal calculateCostsOfFlight( Flight flight ) {

        BigDecimal sm = flight.getStartingMethode().getPrice();

        BigDecimal time;
        BigDecimal costTotalFlyingTime = null;
        if ( flight.getBilledPerson().getPilotLicense() && !flight.getPlane().getPrivatePlane() ) {
            time = BigDecimal.valueOf( ( int ) flight.getTimeFlown() );
            costTotalFlyingTime = ( time.multiply( flight.getPlane().getMinutePrice() ) );
        }
        if ( !flight.getBilledPerson().getPilotLicense() ) {
            costTotalFlyingTime = BigDecimal.valueOf( 0 );
        }
        return sm.add( costTotalFlyingTime );
    }

    public FlightDto flightToFlightDto( Flight fl ) {
        FlightDto dto = new FlightDto();

        dto.setId( fl.getId() );
        dto.setTimeStart( fl.getTimeStart() );
        dto.setTimeEnd( fl.getTimeEnd() );
        dto.setTimeFlown( fl.getTimeFlown() );
        dto.setInstructionFlight( fl.getInstructionFlight() );
        dto.setRemarks( fl.getRemarks() );
        dto.setPlane( fl.getPlane() );
        dto.setAirportStart( fl.getAirportStart() );
        dto.setAirportEnd( fl.getAirportEnd() );
        dto.setStartingMethode( fl.getStartingMethode() );
        dto.setPassenger( fl.getPassenger() );
        dto.setCaptain( fl.getCaptain() );
        dto.setBilledPerson( fl.getBilledPerson() );

        return dto;
    }
}
