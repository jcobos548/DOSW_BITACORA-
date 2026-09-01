package dosw.semana_4.patrones;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {

    private final User user;
    private final List<PreferenceObserver> observers = new ArrayList<>();

    public UserProfile(User user) {
        this.user = user;
    }

    public void addObserver(PreferenceObserver observer) {
        observers.add(observer);
    }

    public void changePreference(String preference) {
        user.setPreference(preference);

        System.out.println(
                "\nPreferencia cambiada a: " + preference
        );

        notifyObservers();
    }

    private void notifyObservers() {
        for (PreferenceObserver observer : observers) {
            observer.onPreferenceChanged(user);
        }
    }
}
