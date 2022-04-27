package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.*;
;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Validated
public class InvoiceDto {

    private Long id;
    private LocalDate creationDate;
    private Person billedPerson;
    private BigDecimal ammount;
private Flight flight;
    public InvoiceDto() {
    }

    public void setInvoiceDto( Long id, LocalDate creationDate, Person billedPerson, BigDecimal ammount, Flight flight ) {
        this.id = id;
        this.creationDate = creationDate;
        this.billedPerson=billedPerson;
        this.ammount = ammount;
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

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount( BigDecimal ammount ) {
        this.ammount = ammount;
    }

    public Flight getFlight() {
        return flight;}

    public void setFlight( Flight flight ) {
        this.flight = flight;
    }
}

