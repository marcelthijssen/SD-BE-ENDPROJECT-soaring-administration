package com.example.sdbesoaringadministration.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int invoiceNumber;

    private BigDecimal ammount;

    private Date creationDate;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "person_id",
            referencedColumnName = "id")
    private Person billedPerson;

    //    Flight information -captain, time-flown
    @ManyToOne
//    @JsonBackReference("flights")
    @JoinColumn(name = "flights_info_id",
            referencedColumnName = "id")
    private Flight flights_info;

    //    T-O-M information -person, tom
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "membership_info_id",
            referencedColumnName = "id")
    private Membership type_of_membership;


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

    public Flight getFlights_info() {
        return flights_info;
    }

    public void setFlights_info( Flight flights_info ) {
        this.flights_info = flights_info;
    }

    public Membership getType_of_membership() {
        return type_of_membership;
    }

    public void setType_of_membership( Membership type_of_membership ) {
        this.type_of_membership = type_of_membership;
    }
//    calculating ionvoice

}
