package br.com.abdiel.patternslab.order.builder;

import br.com.abdiel.patternslab.order.model.Order;
import br.com.abdiel.patternslab.order.model.OrderItem;
import br.com.abdiel.patternslab.product.model.Product;
import br.com.abdiel.patternslab.order.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {

    private String customerEmail;
    private final List<OrderItem> items = new ArrayList<>();

    public OrderBuilder customer(String email) {

        this.customerEmail = email;

        return this;
    }

    public OrderBuilder addItem(Product product, int quantity) {

        items.add(new OrderItem(product, quantity));

        return this;
    }

    public Order build() {

        return new Order(
                UUID.randomUUID(),
                customerEmail,
                items,
                OrderStatus.CREATED
        );
    }
}
