package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDto> getAllInvoices();

    List<InvoiceDto> findInvoicesByBilledPerson( Long plid );


}
