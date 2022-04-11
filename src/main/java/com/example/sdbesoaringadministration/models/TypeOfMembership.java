package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "type_of_memberships")
public class TypeOfMembership {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private BigDecimal costsPerMonth;

//    GETTERS en SETTERS

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

    public BigDecimal getCostsPerMonth() {
        return costsPerMonth;
    }

    public void setCostsPerMonth( BigDecimal costsPerMonth ) {
        this.costsPerMonth = costsPerMonth;
    }
}
