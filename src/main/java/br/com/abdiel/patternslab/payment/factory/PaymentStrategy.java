package br.com.abdiel.patternslab.payment.factory;

import java.math.BigDecimal;

public interface PaymentStrategy {

    PaymentResult pay(BigDecimal amount);
}
