/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Creates an object of Invoice
 * 
 */

package com.example.sdbesoaringadministration.models;

//;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Invoice")
@Table(name = "INVOICES")
public class Invoice {

    @Id
    @Column(name="invoice_number")
    private Long id;

    @Column
    private BigDecimal amount;

    @Column
    private LocalDate creationDate;

    @OneToOne
    @JsonIgnore
    @JoinColumn(
            name = "flight_id",
            referencedColumnName = "id")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "billed_person_id",
            referencedColumnName = "id")
    private Person billedPerson;

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

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public void setFlight(Flight flight){this.flight=flight;}

    public Flight getFlight() {
        return flight;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Invoice invoice = ( Invoice ) o;
        return Objects.equals( id, invoice.id ) && Objects.equals( amount, invoice.amount ) && Objects.equals( creationDate, invoice.creationDate ) && Objects.equals( flight, invoice.flight ) && Objects.equals( billedPerson, invoice.billedPerson );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, amount, creationDate, flight, billedPerson );
    }
}
