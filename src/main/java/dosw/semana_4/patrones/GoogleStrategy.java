package dosw.semana_4.patrones;

public class GoogleStrategy implements AuthStrategy {

    @Override
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("Autenticación mediante Google.");
        return new AuthResult(true);
    }
}
