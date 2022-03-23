package com.example.sdbesoaringadministration.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "typeOfMemberships")
public class TypeOfMembership {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price = price;
    }
}
