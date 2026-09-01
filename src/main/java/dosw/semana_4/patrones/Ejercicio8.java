package dosw.semana_4.patrones;

public class Ejercicio8 {

    public static void main(String[] args) {

        Order order = new OrderBuilder()
                .setSize("GRANDE")
                .setMeat("DOBLE CARNE")
                .addTopping("queso", "lechuga")
                .addSide("papas", "gaseosa")
                .build();

        order.addObserver(new KitchenService());
        order.addObserver(new BillingService());
        order.addObserver(new DeliveryService());

        order.confirm();
    }
}