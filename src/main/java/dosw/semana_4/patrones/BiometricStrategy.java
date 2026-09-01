package dosw.semana_4.patrones;

public class BiometricStrategy implements AuthStrategy {

    @Override
    public AuthResult authenticate(Credentials credentials) {
        System.out.println("Autenticación biométrica.");
        return new AuthResult(true);
    }
}
