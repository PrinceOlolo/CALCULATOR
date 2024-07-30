package me.prince.ololo.calculator.service;

import me.prince.ololo.calculator.dto.CreditDataRq;
import me.prince.ololo.calculator.dto.CreditDataRs;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CreditService {
    public CreditDataRs calculatePayment(CreditDataRq rq) {
        BigDecimal paymentAmount;
        BigDecimal monthlyRate;
        BigDecimal annuityRate;
        Integer term = rq.getTerm();

        monthlyRate = rq.getInterest().divide(BigDecimal.valueOf(12)).divide(BigDecimal.valueOf(100));

        BigDecimal intermediate = BigDecimal.ONE.add(monthlyRate).pow(term);

        annuityRate = monthlyRate.multiply(intermediate).divide(intermediate.subtract(BigDecimal.ONE));

        paymentAmount = annuityRate.multiply(rq.getPrincipal()).setScale(2, RoundingMode.CEILING);

        return new CreditDataRs(paymentAmount);
    }
}
