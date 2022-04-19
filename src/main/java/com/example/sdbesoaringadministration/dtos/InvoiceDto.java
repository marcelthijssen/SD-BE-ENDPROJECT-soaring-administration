package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.*;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceDto {

    private Long id;
    private int invoiceNumber;

    private Date creationDate;

    private Person billedPerson;

    private Flight flight_info;

    private Membership type_of_membership;
    private BigDecimal ammount;


    public void setId( Long id, Date creationDate, BigDecimal ammount, Flight flight_info, Membership type_of_membership ) {
        this.id = id;
        this.creationDate = creationDate;
        this.ammount = ammount;
        this.flight_info = flight_info;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber( int invoiceNumber ) {
        this.invoiceNumber = invoiceNumber;
    }

    public Person getBilledPerson() {
        return billedPerson;
    }

    public void setBilledPerson( Person billedPerson ) {
        this.billedPerson = billedPerson;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate( Date creationDate ) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount( BigDecimal ammount ) {
        this.ammount = ammount;
    }

    public Membership getType_of_membership() {
        return type_of_membership;
    }

    public void setType_of_membership( Membership type_of_membership ) {
        this.type_of_membership = type_of_membership;
    }

    public Flight getFlight_info() {
        return flight_info;
    }

    public void setFlight_info( Flight flight_info ) {
        this.flight_info = flight_info;
    }

    public static InvoiceDto invoiceToInvoiceDto( Invoice i ) {
        InvoiceDto dto = new InvoiceDto();

        dto.setId( i.getId() );
        dto.setInvoiceNumber( i.getInvoiceNumber() );
        dto.setCreationDate( i.getCreationDate() );
        dto.setBilledPerson( i.getBilledPerson() );
        dto.setAmmount( i.getAmmount() );


        return dto;
    }
}

