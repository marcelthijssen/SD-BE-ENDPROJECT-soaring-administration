package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Invoice;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import com.example.sdbesoaringadministration.repositories.InvoiceRepository;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invRepository;
    private final FlightRepository flRepository;
    private final PersonRepository pRepository;

    public InvoiceServiceImpl( InvoiceRepository invRepository, FlightRepository flRepository,  PersonRepository pRepository ) {
        this.invRepository = invRepository;
        this.flRepository = flRepository;
        this.pRepository= pRepository;
    }

    @Override
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoiceList = this.invRepository.findAll();
        List<InvoiceDto> invoiceDtoList = new ArrayList<>();

        for ( Invoice i : invoiceList ) {
            InvoiceDto dto = new InvoiceDto().invoiceToInvoiceDto( i );

            invoiceDtoList.add( dto );
        }
        return invoiceDtoList;
    }

//     get one invoice from one person

    public List<InvoiceDto> findInvoicesByBilledPerson( Long plid ) {
        if ( !invRepository.findInvoicesByBilledPerson( plid ).isEmpty() ) {
            List<Invoice> invoiceList = invRepository.findInvoicesByBilledPerson( plid );
            List<InvoiceDto> invoiceDtoList = new ArrayList<>();

            for ( Invoice i : invoiceList ) {
                InvoiceDto dto = new InvoiceDto().invoiceToInvoiceDto( i );

                invoiceDtoList.add( dto );
            }
            return invoiceDtoList;

        } else {
            throw new RecordNotFoundException( "Invoice doesn't exist" );
        }
    }

    @Override
    public List<Flight> createAnInvoice( Long pid ) {
        Invoice inv = new Invoice();
        List<Flight> flights = flRepository.findFlightsByBilledPersonEquals( pid );
//        1 -  get all flights ids from this person
//        2 - get
//        inv.setBilledPerson( pid );

        return flights;
    }

}
