package br.com.abdiel.patternslab.payment.factory;

import br.com.abdiel.patternslab.payment.service.PaymentService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentServiceTest {

    @Test
    void shouldProcessPixPayment() {

        PaymentService service = new PaymentService(new PaymentFactory());

        PaymentResult result = service.process(
                PaymentMethod.PIX,
                new BigDecimal("100.00")
        );

        assertTrue(result.success());

        assertEquals(
                new BigDecimal("100.00"),
                result.amount()
        );

        assertEquals(
                "Pagamento PIX processado.",
                result.message()
        );
    }

}
