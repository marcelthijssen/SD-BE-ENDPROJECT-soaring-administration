/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Creates an object of Startingmethode
 *
 */

package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity(name = "StartingMethode")
@Table(name = "STARTING_METHODES")
public class StartingMethode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @NotBlank
    private String title;

    @Column
    @NotBlank
    private String unit;

    @Column
    @DecimalMin(value = "0.0", message = "value = 0.0")
    @Digits(integer = 1, fraction = 2)
    private BigDecimal price;
    @OneToMany
            (mappedBy = "startingMethode",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flights;

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit( String unit ) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice( BigDecimal price ) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public void setFlight( List<Flight> flights ) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    void addFlight( Flight flight ) {
        this.flights.add( flight );
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        StartingMethode that = ( StartingMethode ) o;
        return Objects.equals( id, that.id ) && Objects.equals( title, that.title ) && Objects.equals( unit, that.unit ) && Objects.equals( price, that.price ) && Objects.equals( flights, that.flights );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, title, unit, price, flights );
    }


}
