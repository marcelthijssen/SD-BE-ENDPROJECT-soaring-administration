package com.example.sdbesoaringadministration.dtos;


import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.models.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDto {

    private Long id;
    private String name;

    private Set<Person> persons = new HashSet<>();

    public RoleDto() {
    }

    public RoleDto( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

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

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons( Set<Person> persons ) {
        this.persons = persons;
    }

}