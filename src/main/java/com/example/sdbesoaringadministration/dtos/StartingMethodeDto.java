package com.example.sdbesoaringadministration.dtos;

import java.math.BigDecimal;

public class StartingMethodeDto {

    private Long id;

    private String title;
    private BigDecimal price;

    // constructors
    public StartingMethodeDto() {
    }

    public StartingMethodeDto( String title, BigDecimal price ) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice( BigDecimal price ) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }
}
