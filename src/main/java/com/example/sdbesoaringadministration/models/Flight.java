package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
// TODO: calc total time flying
    @NotBlank
    private String captain;
    private String passenger;
    private boolean instructionFlight;
    private String remarks;

//    a plane can have multiple flights
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "plane_id",
            referencedColumnName = "id",
            nullable = true)
//    @JsonManagedReference
    private Plane plane;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime( LocalDateTime startTime ) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime( LocalDateTime endTime ) {
        this.endTime = endTime;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain( String gezagvoerder ) {
        this.captain = gezagvoerder;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger( String passenger ) {
        this.passenger = passenger;
    }

    public boolean isInstructionFlight() {
        return instructionFlight;
    }

    public void setInstructionFlight( boolean instructionFlight ) {
        this.instructionFlight = instructionFlight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks( String remarks ) {
        this.remarks = remarks;
    }

//   OneTwoMany  plane

    public void setPlane( Plane plane ) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }

//    public StartingMethode getStartingMethode() {
//        return startingMethode;
//    }
//
//    public void setStartingMethode( StartingMethode startingMethode ) {
//        this.startingMethode = startingMethode;
//    }


}
