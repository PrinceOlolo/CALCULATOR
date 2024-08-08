package me.prince.ololo.calculator.service;

import me.prince.ololo.calculator.dto.CreditDataRq;
import me.prince.ololo.calculator.dto.CreditDataRs;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class AnnuitetCreditService implements CreditService {
    @Override
    public CreditDataRs calculatePayment(CreditDataRq rq) {
        // Делим годовой процент на количество месяцев в году и приводим к абсолютному выражению
        var monthlyRate = rq.interest()
                .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_EVEN)
                .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_EVEN);

        //Складываем 1 с тем что нашли выше и возводим в степень
        var intermediate = BigDecimal.ONE
                .add(monthlyRate)
                .pow(rq.term());

        // вычисляем коэфицент аннуитетного платежа
        var annuityRate = monthlyRate.multiply(intermediate)
                .divide(intermediate
                        .subtract(BigDecimal.ONE), 10, RoundingMode.HALF_EVEN);

        //добавляем ежемесячный платёж в массив округляя до 2 знаков после запятой
        var paymentAmount =  new BigDecimal[] {annuityRate
                .multiply(rq.principal())
                .setScale(2, RoundingMode.HALF_EVEN)};

        // Возвращаем результат
        return new CreditDataRs(paymentAmount, PaymentType.ANNUITY);
    }
}
