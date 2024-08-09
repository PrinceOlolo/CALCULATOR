package me.prince.ololo.calculator.service;

import me.prince.ololo.calculator.dto.CreditDataRq;
import me.prince.ololo.calculator.dto.CreditDataRs;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DifferentialCreditService implements CreditService {
    @Override
    public CreditDataRs calculatePayment(CreditDataRq rq) {

        // Общая сумма кредита
        var remainingDebt = rq.principal();

        // Массив для хранения сумм платежей
        var paymentAmount = new BigDecimal[rq.term()];

        // Основной долг, выплачиваемый каждый месяц
        var principalPayment = remainingDebt.divide(BigDecimal.valueOf(rq.term()), 100, RoundingMode.HALF_EVEN);

        for (int pastPeriod = 0; pastPeriod < rq.term(); pastPeriod++) {

            // Процентная часть от оставшегося долга
            var interestPayment = remainingDebt.multiply(rq.interest().divide(BigDecimal.valueOf(1200), 100, RoundingMode.HALF_EVEN));

            // Общий платеж за период
            var differentialRate = principalPayment.add(interestPayment);

            // Уменьшаем оставшийся долг на величину выплаченного основного долга
            remainingDebt = remainingDebt.subtract(principalPayment);

            // Сохраняем сумму платежа в массив
            paymentAmount[pastPeriod] = differentialRate.setScale(2, RoundingMode.HALF_EVEN);
        }

        // Возвращаем результат
        return new CreditDataRs(paymentAmount, PaymentType.DIFFERENTIATED);

    }
}
