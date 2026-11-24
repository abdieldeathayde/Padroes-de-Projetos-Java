package br.com.abdiel.patternslab.order.validation;

import br.com.abdiel.patternslab.order.validation.OrderValidator;

public abstract class AbstractOrderValidator implements OrderValidator {

    private OrderValidator next;

    @Override
    public OrderValidator setNext(OrderValidator next) {
        this.next = next;

        return next;
    }

    protected void validateNext (
            OrderValidationContext context
            ) {
        if (next != null) {
            next.validate(context);
        }
    }

}
