package com.example.sdbesoaringadministration.dtos;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class StartingMethodeDto {

    private Long id;

    private String title;
    private String price;

    // constructors
    public StartingMethodeDto() {
    }

    public StartingMethodeDto( String title, String price ) {
        this.title = title;
        this.price = price;
    }

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
