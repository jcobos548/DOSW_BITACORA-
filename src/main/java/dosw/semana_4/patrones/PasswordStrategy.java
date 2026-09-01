package dosw.semana_4.patrones;

public class PasswordStrategy implements AuthStrategy {

    @Override
    public AuthResult authenticate(Credentials credentials) {

        boolean valid =
                credentials.getUsername() != null &&
                        !credentials.getUsername().isBlank() &&
                        credentials.getPassword() != null &&
                        !credentials.getPassword().isBlank();

        System.out.println("Autenticación usuario/contraseña.");

        return new AuthResult(valid);
    }
}