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

    @Length(min=4, max=4, message = "Must have exactly 4 characters")
    private String Icao;

    @NotBlank(message = "Location can not be empty")
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
