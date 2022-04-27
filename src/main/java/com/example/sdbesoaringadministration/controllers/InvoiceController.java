package com.example.sdbesoaringadministration.controllers;


import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invService;

    public InvoiceController( InvoiceService invService ) {
        this.invService = invService;
    }

    @GetMapping("/invoices")
    public ResponseEntity<Object> getAllInvoices() {
        List<InvoiceDto> invoiceDtoList = invService.getAllInvoices();

        return new ResponseEntity<>( invoiceDtoList, HttpStatus.OK );
    }

    @GetMapping("/invoices/billedperson/{pid}")
    public ResponseEntity<Object> getInvoiceByBilledPerson( @PathVariable(name = "pid") Long pid ) {
        List<InvoiceDto> invoices = invService.findInvoicesByBilledPerson( pid );
        return new ResponseEntity<>( invoices, HttpStatus.OK );
    }


//@PutMapping


}
