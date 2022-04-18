package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String Icao;
    private String city;
    private String country;

    // A flight can only have on airport
    @OneToMany
            (mappedBy = "airportStart",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> airportStart;

    @OneToMany
            (mappedBy = "airportEnd",
                    fetch= FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> airportEnd;


//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getIcao() {
        return Icao;
    }

    public void setIcao( String Icao ) {
        this.Icao = Icao;
    }
    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }
}
