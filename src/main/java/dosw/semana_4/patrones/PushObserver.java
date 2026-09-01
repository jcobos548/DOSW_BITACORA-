package dosw.semana_4.patrones;

public class PushObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Notificación Push: " + message);
    }
}