package com.example.sdbesoaringadministration.models;

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Entity
//@Data
@Table(name = "starting_methodes")
public class StartingMethode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String unit;

    @DecimalMin(value = "0.0", message="value = 0.0")
    @Digits(integer=1, fraction=2)
    private BigDecimal price;

    // A flight can only have one  startingmethode
    @OneToMany
            (mappedBy = "startingMethode",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flights;



    //getters an setters
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

    public BigDecimal getPrice( ) {
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

    // Flight
    public void setFlight(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    void addFlight( Flight flight) {
        this.flights.add(flight);
    }


}
