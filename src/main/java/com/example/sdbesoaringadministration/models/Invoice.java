package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int invoiceNumber;


    public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "billed_person_id")
    @JsonBackReference("person")
    private Person billed_person;

    //    methode to calculate

//     If flight is instruction flight --> the passenger is paying for
//    Starting-method
//    time flown
//


    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber( int invoiceNumber ) {
        this.invoiceNumber = invoiceNumber;
    }

    public Person getBilled_person() {
        return billed_person;
    }

    public void setBilled_person( Person billed_person ) {
        this.billed_person = billed_person;
    }
}
