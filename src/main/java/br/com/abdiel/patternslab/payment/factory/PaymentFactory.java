package br.com.abdiel.patternslab.payment.factory;

import br.com.abdiel.patternslab.payment.factory.BoletoPaymentStrategy;
import br.com.abdiel.patternslab.payment.factory.CreditCardPaymentStrategy;
import br.com.abdiel.patternslab.payment.factory.PixPaymentStrategy;

public class PaymentFactory {

    public PaymentStrategy create(PaymentMethod method) {

        return switch (method) {

            case PIX -> new PixPaymentStrategy();

            case CREDIT_CARD -> new CreditCardPaymentStrategy();

            case BOLETO -> new BoletoPaymentStrategy();
        };
    }
}
