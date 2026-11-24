package br.com.abdiel.patternslab.order.validation;

public class EmptyOrderValidator extends AbstractOrderValidator {

    @Override
    public void validate(OrderValidationContext context) {

        if (context.getOrder().getItems().isEmpty()) {
            throw new IllegalArgumentException(
                    "Pedido deve possuir pelo menos um item!"
            );
        }

        validateNext(context);

    }


}
