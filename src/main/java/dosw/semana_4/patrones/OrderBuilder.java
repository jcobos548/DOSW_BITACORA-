package dosw.semana_4.patrones;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    private String size;
    private String meat;
    private final List<String> toppings = new ArrayList<>();
    private final List<String> sides = new ArrayList<>();

    public OrderBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public OrderBuilder setMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public OrderBuilder addTopping(String... topping) {
        for (String item : topping) {
            toppings.add(item);
        }
        return this;
    }

    public OrderBuilder addSide(String... side) {
        for (String item : side) {
            sides.add(item);
        }
        return this;
    }

    public Order build() {

        if (size == null || size.isBlank()) {
            throw new IllegalStateException(
                    "El pedido debe tener un tamaño."
            );
        }

        if (meat == null || meat.isBlank()) {
            throw new IllegalStateException(
                    "El pedido debe tener un tipo de carne."
            );
        }

        return new Order(
                size,
                meat,
                toppings,
                sides
        );
    }
}