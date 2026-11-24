package br.com.abdiel.patternslab.order.validation;

public class CustomerValidator
        extends AbstractOrderValidator {

    @Override
    public void validate(OrderValidationContext context) {

        String email = context.getOrder().getCustomerEmail();

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "E-mail do cliente é obrigatório"
            );
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException(
                    "E-mail inválido"
            );
        }

        validateNext(context);
    }
}