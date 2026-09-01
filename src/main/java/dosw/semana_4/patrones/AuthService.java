package dosw.semana_4.patrones;

public class AuthService {

    private AuthStrategy strategy;

    public AuthService(AuthStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AuthStrategy strategy) {
        this.strategy = strategy;
    }

    public AuthResult authenticate(Credentials credentials) {
        return strategy.authenticate(credentials);
    }
}
