package dosw.semana_4.patrones;

public class SmsObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Notificación por SMS: " + message);
    }
}