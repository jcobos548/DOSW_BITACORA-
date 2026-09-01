package dosw.semana_4.patrones;

public class EmailObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Notificación por Email: " + message);
    }
}