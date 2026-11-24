package br.com.abdiel.patternslab.payment.service;

import br.com.abdiel.patternslab.payment.factory.PaymentFactory;
import br.com.abdiel.patternslab.payment.factory.PaymentMethod;
import br.com.abdiel.patternslab.payment.factory.PaymentResult;
import br.com.abdiel.patternslab.payment.factory.PaymentStrategy;

import java.math.BigDecimal;

public class PaymentService {

    private final PaymentFactory factory;

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public PaymentResult process(
            PaymentMethod method,
            BigDecimal amount
    ) {
        PaymentStrategy strategy = factory.create(method);

        return strategy.pay(amount);
    }
}
