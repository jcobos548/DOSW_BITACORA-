package dosw.semana_4.patrones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final String size;
    private final String meat;
    private final List<String> toppings;
    private final List<String> sides;

    private final List<OrderObserver> observers = new ArrayList<>();

    public Order(
            String size,
            String meat,
            List<String> toppings,
            List<String> sides
    ) {
        this.size = size;
        this.meat = meat;
        this.toppings = List.copyOf(toppings);
        this.sides = List.copyOf(sides);
    }

    public String getSize() {
        return size;
    }

    public String getMeat() {
        return meat;
    }

    public List<String> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public List<String> getSides() {
        return Collections.unmodifiableList(sides);
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void confirm() {
        System.out.println("Pedido confirmado.");
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
}
