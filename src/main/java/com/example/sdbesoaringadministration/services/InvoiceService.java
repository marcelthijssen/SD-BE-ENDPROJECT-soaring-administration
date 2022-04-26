package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Invoice;
import com.example.sdbesoaringadministration.models.Person;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDto> getAllInvoices();

    List<InvoiceDto> findInvoicesByBilledPerson( Long plid );

//    public List<Flight> createAnInvoice( Long pid );

}
