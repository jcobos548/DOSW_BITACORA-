package dosw.semana_4.patrones;

public class KitchenService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println(
                "Cocina: preparando hamburguesa " +
                        order.getSize() +
                        " con " +
                        order.getMeat()
        );
    }
}