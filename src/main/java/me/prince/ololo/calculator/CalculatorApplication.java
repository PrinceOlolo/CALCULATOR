package me.prince.ololo.calculator;

import me.prince.ololo.calculator.dto.CreditDataRq;
import me.prince.ololo.calculator.service.CreditService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
        BigDecimal testPrincipal = new BigDecimal("100000");
        Integer testTerm = 24 ;
        BigDecimal testInterest = new BigDecimal("7.5");
        CreditDataRq rq = new CreditDataRq(testPrincipal, testTerm, testInterest);
        CreditService crs = new CreditService();
        System.out.println(crs.calculatePayment(rq).getPayment());
    }

}
