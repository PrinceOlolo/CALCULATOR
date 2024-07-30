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

    }

}
