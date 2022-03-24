package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "typeOfMemberships")
public class TypeOfMembership {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private int costsPerMonth;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public int getCostsPerMonth() {
        return costsPerMonth;
    }

    public void setCostsPerMonth( int costsPerMonth ) {
        this.costsPerMonth = costsPerMonth;
    }
}
