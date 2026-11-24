package br.com.abdiel.patternslab.payment.factory;

import java.math.BigDecimal;

public class BoletoPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay(BigDecimal amount) {

        return new PaymentResult(
                true,
                "Boleto gerado com sucesso.",
                amount
        );
    }
}
