package br;

import br.com.abdiel.patternslab.payment.factory.PaymentFactory;
import br.com.abdiel.patternslab.payment.factory.PaymentMethod;
import br.com.abdiel.patternslab.payment.factory.PaymentResult;
import br.com.abdiel.patternslab.payment.service.PaymentService;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentFactory factory = new PaymentFactory();

        PaymentService service = new PaymentService(factory);

        PaymentResult result = service.process(
                PaymentMethod.PIX,
                new BigDecimal("250.00")
        );

        System.out.println(result.message());
        System.out.println("Valor: " + result.amount());
        System.out.println("Sucesso: " + result.success());


    }
}