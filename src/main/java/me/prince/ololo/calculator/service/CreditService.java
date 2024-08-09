package me.prince.ololo.calculator.service;

import me.prince.ololo.calculator.dto.CreditDataRq;
import me.prince.ololo.calculator.dto.CreditDataRs;

public interface CreditService {
    CreditDataRs calculatePayment(CreditDataRq rq);
}
