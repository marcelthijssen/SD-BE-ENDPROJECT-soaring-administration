/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Data Transfer Object
 *
 */

package com.example.sdbesoaringadministration.dtos;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


@Validated
public class StartingMethodeDto {

    private Long id;
    @NotBlank(message = "Title can not be empty")
    private String title;
    @NotBlank(message = "Unit can not be empty")
    private String unit;
    @Column(precision = 10, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

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
