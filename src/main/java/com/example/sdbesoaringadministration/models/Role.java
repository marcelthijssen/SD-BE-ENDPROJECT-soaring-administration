package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<AUser> ausers = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Set<AUser> getAUsers() {
        return ausers;
    }

    public void setAUsers( Set<AUser> ausers ) {
        this.ausers = ausers;
    }

}
