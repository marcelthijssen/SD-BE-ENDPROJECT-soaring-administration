package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Invoice;
import com.example.sdbesoaringadministration.repositories.InvoiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invRepository;

    public InvoiceServiceImpl( InvoiceRepository invRepository ) {
        this.invRepository = invRepository;

    }

    @Override
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoiceList = this.invRepository.findAll();
        List<InvoiceDto> invoiceDtoList = new ArrayList<>();

        for ( Invoice i : invoiceList ) {
            invoiceDtoList.add(invoiceToInvoiceDto( i ));
        }
        return invoiceDtoList;
    }

    public List<InvoiceDto> findInvoicesByBilledPerson( Long plid ) {
        if ( !invRepository.findInvoicesByBilledPerson( plid ).isEmpty() ) {
            List<Invoice> invoiceList = invRepository.findInvoicesByBilledPerson( plid );
            List<InvoiceDto> invoiceDtoList = new ArrayList<>();

            for ( Invoice i : invoiceList ) {
                invoiceDtoList.add(invoiceToInvoiceDto( i ));
            }
            return invoiceDtoList;

        } else {
            throw new RecordNotFoundException( "Invoice doesn't exist", HttpStatus.NOT_FOUND );
        }
    }


    public static InvoiceDto invoiceToInvoiceDto( Invoice i ) {
        InvoiceDto dto = new InvoiceDto();

        dto.setId( i.getId() );
        dto.setCreationDate( i.getCreationDate() );
        dto.setFlight( i.getFlight() );
        dto.setBilledPerson( i.getBilledPerson() );
        dto.setAmmount( i.getAmount() );

        return dto;
    }
}