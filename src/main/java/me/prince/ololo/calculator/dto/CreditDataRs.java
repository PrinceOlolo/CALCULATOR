package me.prince.ololo.calculator.dto;

import java.math.BigDecimal;

// TODO сделать рекордом
public class CreditDataRs {
    private final BigDecimal payment;

    public CreditDataRs(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getPayment() {
        return payment;
    }
}
