package dosw.semana_4.patrones;

public class DeliveryService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println(
                "Domiciliario: preparando ruta de entrega."
        );
    }
}