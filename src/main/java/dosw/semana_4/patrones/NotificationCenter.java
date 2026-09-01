package dosw.semana_4.patrones;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {

    private static NotificationCenter instance;
    private final List<Observer> observers;

    private NotificationCenter() {
        observers = new ArrayList<>();
    }

    public static NotificationCenter getInstance() {
        if (instance == null) {
            instance = new NotificationCenter();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
