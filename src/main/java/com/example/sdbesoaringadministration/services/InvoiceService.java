package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.models.Invoice;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDto> getAllInvoices();

    public List<InvoiceDto> findInvoicesByBilledPerson( Long plid );

}
