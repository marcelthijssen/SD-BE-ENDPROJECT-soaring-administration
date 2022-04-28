package com.example.sdbesoaringadministration.models;

//;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="invoice_number")
    private Long id;
    private BigDecimal ammount;
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

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount( BigDecimal ammount ) {
        this.ammount = ammount;
    }

    public void setFlight(Flight flight){this.flight=flight;}

    public Flight getFlight() {
        return flight;
    }
}
