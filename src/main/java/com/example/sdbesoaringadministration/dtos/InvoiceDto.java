package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.*;
;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceDto {

    private Long id;
    private LocalDate creationDate;
    private Person billedPerson;
    private BigDecimal amount;
private Flight flight;
    public InvoiceDto() {
    }

    public void setInvoiceDto( Long id, LocalDate creationDate, Person billedPerson, BigDecimal amount, Flight flight ) {
        this.id = id;
        this.creationDate = creationDate;
        this.billedPerson=billedPerson;
        this.amount = amount;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


    public Person getBilledPerson() {
        return billedPerson;
    }

    public void setBilledPerson( Person billedPerson ) {
        this.billedPerson = billedPerson;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate( LocalDate creationDate ) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public Flight getFlight() {
        return flight;}

    public void setFlight( Flight flight ) {
        this.flight = flight;
    }

}

