package me.prince.ololo.calculator.dto;

import java.math.BigDecimal;

// TODO сделать рекордом
public class CreditDataRq {
    private final BigDecimal principal;
    private final Integer term;
    private final BigDecimal interest;

    public CreditDataRq(BigDecimal principal, Integer term, BigDecimal interest) {
        this.principal = principal;
        this.term = term;
        this.interest = interest;
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
