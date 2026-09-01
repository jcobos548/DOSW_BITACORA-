package dosw.semana_4.patrones;

public class BillingService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println(
                "Facturación: generando cuenta del pedido."
        );
    }
}