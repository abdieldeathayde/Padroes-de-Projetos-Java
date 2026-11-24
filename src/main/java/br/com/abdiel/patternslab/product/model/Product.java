package br.com.abdiel.patternslab.product.model;

import java.math.BigDecimal;

public class Product {

    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final int stock;

    public Product(
            Long id,
            String name,
            BigDecimal price,
            int stock
    ) {
        if (price == null || price.signum() < 0) {
            throw new IllegalArgumentException(
                    "Preço inválido."
            );
        }

        if (stock < 0) {
            throw new IllegalArgumentException(
                    "Estoque não pode ser negativo."
            );
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

}
