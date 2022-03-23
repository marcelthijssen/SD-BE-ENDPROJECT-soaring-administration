package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "airports")
public class Airport {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    private String ICAO;
    private String location;


    public String getICAO() {
        return ICAO;
    }

    public void setICAO( String ICAO ) {
        this.ICAO = ICAO;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }
}
