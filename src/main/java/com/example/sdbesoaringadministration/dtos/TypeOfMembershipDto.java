package com.example.sdbesoaringadministration.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class TypeOfMembershipDto {

    private Long id;

    @NotBlank(message = "Must have a title")
    private String title;

    @Column(precision=10, scale=2)
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=4, fraction=2)
    private BigDecimal costsPerMonth;

    @Column(precision=10, scale=2)
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=4, fraction=2)
    private BigDecimal max;

    //    Constructors
    public TypeOfMembershipDto() {
    }

    public TypeOfMembershipDto( Long id, String title, BigDecimal costsPerMonth, BigDecimal max ) {
        this.id = id;
        this.title = title;
        this.costsPerMonth = costsPerMonth;
        this.max = max;
    }


    //    GETTERS and SETTERS
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

    public BigDecimal getCostsPerMonth() {
        return costsPerMonth;
    }

    public void setCostsPerMonth( BigDecimal costsPerMonth ) {
        this.costsPerMonth = costsPerMonth;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax( BigDecimal max ) {
        this.max = max;
    }
}
