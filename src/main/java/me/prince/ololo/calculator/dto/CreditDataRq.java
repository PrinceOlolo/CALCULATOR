package me.prince.ololo.calculator.dto;

import java.math.BigDecimal;

public class CreditDataRq {

    private final BigDecimal principal;
    private final Integer term;
    private final BigDecimal interest;

    public CreditDataRq(BigDecimal principal, Integer term, BigDecimal interest) {
        this.principal = principal; //сумма
        this.term = term; //срок
        this.interest = interest; //проценты
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
