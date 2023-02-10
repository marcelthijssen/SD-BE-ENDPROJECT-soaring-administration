/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Controller of the endpoints for '/flights
 * GET
 * '/getAllInvoices'
 * '/billedperson/{person_id}' returns aal invoices of a specific person
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping("/billedperson/{person_id}")
    public ResponseEntity<Object> getInvoiceByBilledPerson( @PathVariable(name = "person_id") Long person_id ) {
        List<InvoiceDto> invoices = invoiceService.findInvoicesByBilledPerson( person_id );
        return new ResponseEntity<>( invoices, HttpStatus.OK );
    }

}
