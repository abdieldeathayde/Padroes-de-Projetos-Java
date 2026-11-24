package br.com.abdiel.patternslab.payment.factory;

import java.math.BigDecimal;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    @Override
    public PaymentResult pay(BigDecimal amount) {

        return new PaymentResult(
                true,
                "Pagamento com cartão processado.",
                amount
        );
    }
}
