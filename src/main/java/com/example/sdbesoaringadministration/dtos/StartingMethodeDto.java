package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.StartingMethode;
;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;


@Validated
public class StartingMethodeDto {

    private Long id;
    private String title;
    private String unit;
    //    BigDecimal bd1 = new BigDecimal.valueOf(...) OF BigDecimal("...")
    private BigDecimal price;

    // constructors
    public StartingMethodeDto() {
    }

    public StartingMethodeDto( Long id, String title, String unit, BigDecimal price ) {
        this.id = id;
        this.title = title;
        this.unit = unit;
        this.price = price;
    }


    //getters an setters
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit( String unit ) {
        this.unit = unit;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice( BigDecimal price ) {
        this.price = price;
    }

}
