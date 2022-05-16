/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Controller of the endpoints for '/flights
 * GET
 * '/getAllInvoices'
 * '/billedperson/{personId}' returns aal invoices of a specific person
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController( InvoiceService invoiceService ) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllInvoices() {
        List<InvoiceDto> invoiceDtoList = invoiceService.getAllInvoices();

        return new ResponseEntity<>( invoiceDtoList, HttpStatus.OK );
    }

    @GetMapping("/billedperson/{personId}")
    public ResponseEntity<Object> getInvoiceByBilledPerson( @PathVariable(name = "personId") Long personId ) {
        List<InvoiceDto> invoices = invoiceService.findInvoicesByBilledPerson( personId );
        return new ResponseEntity<>( invoices, HttpStatus.OK );
    }

}
