package br.com.abdiel.patternslab.payment.factory;

import br.com.abdiel.patternslab.payment.factory.PaymentStrategy;

import java.math.BigDecimal;

public class PixPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                true,
                "Pagamento PIX processado",
                amount
        );
    }
}
