package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.dtos.InvoiceDto;
import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Invoice;
import com.example.sdbesoaringadministration.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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


    @GetMapping("/invoices/{pid}")
    public ResponseEntity<Object> getInvoiceByPerson( @PathVariable(name = "pid") Long pid ) {
        List<InvoiceDto> invoices = invService.findInvoicesByBilledPerson( pid );
        return new ResponseEntity<>( invoices, HttpStatus.OK );
    }
    @GetMapping("/invoices/person/{pid}")
    public ResponseEntity<List<InvoiceDto>> findInvoicesByBilledPerson( @PathVariable(name = "pid") Long pid ) {
        List<InvoiceDto> invoices = invService.findInvoicesByBilledPerson( pid );

        return new ResponseEntity<>( invoices, HttpStatus.OK );
    }

//    @PostMapping("/invoices/person/{pid}")
//    public ResponseEntity<List<Invoice>> createInvoiceById( @PathVariable(name = "pid") Long pid
////            , BindingResult br
//    ) {
////        if ( br.hasErrors() ) {
////            StringBuilder sb = new StringBuilder();
////            for ( FieldError fe : br.getFieldErrors() ) {
////                sb.append( fe.getDefaultMessage() );
////                sb.append( "\n" );
////            }
////            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
////        } else {
//        List<Invoice> invoices = invService.findInvoicesByBilledPerson( pid );
////            invService.createAnInvoice( pid );
//        return new ResponseEntity<>( invoices, HttpStatus.OK );        }
////    }

}
