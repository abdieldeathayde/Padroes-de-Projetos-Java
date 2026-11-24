package br.com.abdiel.patternslab.payment.factory;

import java.math.BigDecimal;

public record PaymentResult(
        boolean success,
        String message,
        BigDecimal amount
) {}
