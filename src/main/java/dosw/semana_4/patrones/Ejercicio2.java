package dosw.semana_4.patrones;

public class Ejercicio2 {

    public static void main(String[] args) {

        NotificationCenter center = NotificationCenter.getInstance();

        Observer email = new EmailObserver();
        Observer sms = new SmsObserver();
        Observer push = new PushObserver();

        center.addObserver(email);
        center.addObserver(sms);
        center.addObserver(push);

        center.notifyObservers("Nuevo pedido recibido");
    }
}