package br.com.abdiel.patternslab.order.validation;

public interface OrderValidator {

    void validate(OrderValidationContext context);

    OrderValidator setNext(OrderValidator next);
}
