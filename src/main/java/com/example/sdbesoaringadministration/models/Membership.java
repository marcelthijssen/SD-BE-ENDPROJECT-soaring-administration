package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
//@Data
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private BigDecimal costsPerMonth;

    @OneToMany(mappedBy = "membership",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Person> persons;

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

//    public List<Person> getMemberships() {
//        return memberships;
//    }
//
//    public void setMemberships( List<Person> memberships ) {
//        this.memberships = memberships;
//    }
}
