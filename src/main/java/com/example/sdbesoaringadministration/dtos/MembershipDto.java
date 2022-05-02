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

import com.example.sdbesoaringadministration.models.Membership;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Validated
public class MembershipDto {
    private Long id;
    @NotBlank(message = "Must have a title")
    private String title;
    @Column(precision = 10, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal costsPerMonth;

    public MembershipDto() {
    }
    public MembershipDto( Long id, String title, BigDecimal costsPerMonth ) {
        this.id = id;
        this.title = title;
        this.costsPerMonth = costsPerMonth;
    }

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

}
