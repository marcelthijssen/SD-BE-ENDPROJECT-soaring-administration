package com.example.sdbesoaringadministration.dtos;

import com.example.sdbesoaringadministration.models.StartingMethode;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

public class StartingMethodeDto {

    private Long id;

    private String title;
    private String unit;
//    BigDecimal bd1 = new BigDecimal.valueOf(...) OF BigDecimal("...")
    private BigDecimal price;
    private BigDecimal max;

    // constructors
    public StartingMethodeDto() {
    }

    public StartingMethodeDto( String title, String unit, BigDecimal price, BigDecimal max ) {
        this.title = title;
        this.unit = unit;
        this.price = price;
        this.max = max;
    }



    //getters an setters
    public BigDecimal getMax( @DecimalMin("0.0") @Digits(integer = 1, fraction = 2) BigDecimal max) {
        return max;
    }

    public void setMax( BigDecimal max ) {
        this.max = max;
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

    public BigDecimal getPrice( @DecimalMin("0.0") @Digits(integer = 1, fraction = 2) BigDecimal price ) {
        return this.price;
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
