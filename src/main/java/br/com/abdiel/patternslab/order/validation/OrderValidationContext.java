package br.com.abdiel.patternslab.order.validation;

import br.com.abdiel.patternslab.order.model.Order;

public class OrderValidationContext {

    private final Order order;

    public OrderValidationContext(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
