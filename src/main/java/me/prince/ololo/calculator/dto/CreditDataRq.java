package me.prince.ololo.calculator.dto;

import java.math.BigDecimal;

public record CreditDataRq (BigDecimal principal, Integer term, BigDecimal interest){

}
