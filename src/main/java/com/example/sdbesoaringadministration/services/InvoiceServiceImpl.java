package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Invoice;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import com.example.sdbesoaringadministration.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invRepository;
    private final FlightRepository flRepository;

    public InvoiceServiceImpl( InvoiceRepository invRepository, FlightRepository flRepository ) {
        this.invRepository = invRepository;
        this.flRepository = flRepository;
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
            throw new RecordNotFoundException( "Plane or flight doesn't exist" );
        }
    }

}
