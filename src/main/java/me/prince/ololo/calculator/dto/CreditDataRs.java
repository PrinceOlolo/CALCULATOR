package me.prince.ololo.calculator.dto;

import me.prince.ololo.calculator.service.PaymentType;

import java.math.BigDecimal;

public record CreditDataRs (BigDecimal[] payment, PaymentType paymentType){

}
