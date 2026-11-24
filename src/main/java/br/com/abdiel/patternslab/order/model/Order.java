package br.com.abdiel.patternslab.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    private final String customerEmail;
    private final List<OrderItem> items;
    private final OrderStatus status;

    public Order(
            UUID id,
            String customerEmail,
            List<OrderItem> items,
            OrderStatus status
    ) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>(items);
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getSubtotal() {

        return items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}