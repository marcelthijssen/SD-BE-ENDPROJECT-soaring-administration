package com.example.sdbesoaringadministration.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String Icao;
    private String location;


//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    public String getIcao() {
        return Icao;
    }

    public void setIcao( String Icao ) {
        this.Icao = Icao;
    }

}
