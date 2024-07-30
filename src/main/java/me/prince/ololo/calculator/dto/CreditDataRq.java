package me.prince.ololo.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreditDataRq {
    @JsonProperty("principal")
    private final BigDecimal principal;
    @JsonProperty("term")
    private final Integer term;
    @JsonProperty("interest")
    private final BigDecimal interest;

    public CreditDataRq(BigDecimal principal, Integer term, BigDecimal interest) {
        this.principal = principal; //сумма
        this.term = term; //срок
        this.interest = interest; //проценты
        System.out.println(principal + " " + term + " " + interest);
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public Integer getTerm() {
        return term;
    }

    public BigDecimal getInterest() {
        return interest;
    }

}
