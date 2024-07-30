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

        monthlyRate = rq.getInterest().divide(BigDecimal.valueOf(12), 10, RoundingMode.UP).divide(BigDecimal.valueOf(100), 10, RoundingMode.UP);

        BigDecimal intermediate = BigDecimal.ONE.add(monthlyRate).pow(rq.getTerm());

        annuityRate = monthlyRate.multiply(intermediate).divide(intermediate.subtract(BigDecimal.ONE),10, RoundingMode.UP);

        paymentAmount = annuityRate.multiply(rq.getPrincipal()).setScale(2, RoundingMode.CEILING);

        return new CreditDataRs(paymentAmount);
    }
}
