package dosw.semana_4.patrones;

public class AuthResult {

    private final boolean authenticated;

    public AuthResult(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}