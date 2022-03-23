package com.example.sdbesoaringadministration.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StartingMethode {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String price;


    //getters an setters
    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice( String price ) {
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }
}
