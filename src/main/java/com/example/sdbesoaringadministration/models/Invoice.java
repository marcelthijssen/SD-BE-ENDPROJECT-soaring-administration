package com.example.sdbesoaringadministration.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {
    private Long id;


    public void setId( Long id ) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

//    methode to calculate

//     If flight is instruction flight --> the passenger is paying for
//    Starting-method
//    time flown
//


}
