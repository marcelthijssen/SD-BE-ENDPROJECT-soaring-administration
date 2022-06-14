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
import com.example.sdbesoaringadministration.enums.FlightTypeEnum;
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
    public FlightDto getFlightById( Long flight_id ) {
        if ( flightRepository.findById( flight_id ).isPresent() ) {
            Flight flight = flightRepository.findById( flight_id ).get();
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
    public void deleteFlightById( Long flight_id ) {
        if ( flightRepository.findById( flight_id ).isPresent() ) {
            flightRepository.deleteById( flight_id );
        } else {
            throw new RecordNotFoundException( "No flight found", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public FlightDto updateFlight( Long flight_id, FlightDto dto ) {
        if ( flightRepository.findById( flight_id ).isPresent() ) {
            Flight fl = flightRepository.findById( flight_id ).get();

            fl.setId(dto.getId());
            fl.setTimeStart( dto.getTimeStart() );
            fl.setTimeEnd( dto.getTimeEnd() );
            fl.setTimeFlown( dto.getTimeFlown() );
            fl.setFlightType( dto.getFlightType() );
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
    public void assignPlaneToFlight( Long flight_id, Long plane_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var optionalPlane = planeRepository.findById( plane_id );

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
    public void assignAirportStartToFlight( Long flight_id, Long aperson_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var optionalAirportStart = airportRepository.findById( aperson_id );

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
    public void assignAirportEndToFlight( Long flight_id, Long airportEnd_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var optionalAirportEnd = airportRepository.findById( airportEnd_id );

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
    public void assignStartingMethodeToFlight( Long flight_id, Long startingMethode_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var optionalStartingMethode = startingMethodeRepository.findById( startingMethode_id );

        if ( optionalFlight.isPresent() && optionalStartingMethode.isPresent() ) {
            var flight = optionalFlight.get();
            var startingMethode = optionalStartingMethode.get();

            flight.setStartingMethode( startingMethode );
            flightRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or startingmethode doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    public void assignCaptainToFlight( Long flight_id, Long captain_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var optionalPerson = personRepository.findById( captain_id );

        if ( optionalFlight.isPresent() && optionalPerson.isPresent() ) {
            var flight = optionalFlight.get();
            var person = optionalPerson.get();

            flight.setCaptain( person );
            flightRepository.save( flight );
        } else {
            throw new RecordNotFoundException( "Flight or this person doesn't exist", HttpStatus.NOT_FOUND );
        }
    }

    public void assignPassengerToFlight( Long flight_id, Long psid ) {
        var optionalFlight = flightRepository.findById( flight_id );
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


    public FlightDto assignInstructionFlightToFlight( Long flight_id, FlightDto dto ) {
        if ( flightRepository.findById( flight_id ).isPresent() ) {
            Flight fl = flightRepository.findById( flight_id ).get();
            fl.setFlightType( dto.getFlightType() );

            flightRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found", HttpStatus.NOT_FOUND );
        }
    }

    public void assignTimeStart( Long flight_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var flight = optionalFlight.get();
        flight.setTimeStart( ( LocalDateTime.now() ) );
        flightRepository.save( flight );
    }

    public void assignTimeEnd( Long flight_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var flight = optionalFlight.get();
        flight.setTimeEnd( ( LocalDateTime.now() ) );
        flight.setTimeFlown( calculateTimeFlown( flight.getTimeStart(), flight.getTimeEnd() ) ); // calculating adding timeFlown

        if ( flight.getFlightType() == FlightTypeEnum.INSTRUCTION_FLIGHT ) {
            flight.setBilledPerson( flight.getPassenger() );
        } else {
            flight.setBilledPerson( flight.getCaptain() );
        }
        flightRepository.save( flight );
    }

    @Override
    public FlightDto updateRemarksToFLight( Long flight_id, FlightDto dto ) {
        if ( flightRepository.findById( flight_id ).isPresent() ) {
            Flight fl = flightRepository.findById( flight_id ).get();
            fl.setRemarks( dto.getRemarks() );

            flightRepository.save( fl );
            return dto;
        } else {
            throw new RecordNotFoundException( "Flight not found", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public List<FlightDto> getFlightsByCaptain_id( Long captain_id ) {
        try {
            List<Flight> flightList = flightRepository.findFlightsByCaptain_Id( captain_id );
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

    public ResponseEntity<String> createInvoiceFromFLight( Long flight_id ) {
        var optionalFlight = flightRepository.findById( flight_id );
        var optionalInvoice = invoiceRepository.findById( flight_id );
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
        dto.setFlightType( fl.getFlightType() );
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
