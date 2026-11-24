package br.com.abdiel.patternslab.order.model;

import br.com.abdiel.patternslab.product.model.Product;

import java.math.BigDecimal;

public class OrderItem {

    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Produto não pode ser nulo!"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantidade deve ser maior que zero."
            );
        }

        this.product = product;
        this.quantity = quantity;

    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubtotal() {

        return product.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }

}
