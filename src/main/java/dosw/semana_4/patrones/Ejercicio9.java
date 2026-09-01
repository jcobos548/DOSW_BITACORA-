package dosw.semana_4.patrones;

public class Ejercicio9 {

    public static void main(String[] args) {

        Credentials credentials =
                new Credentials("usuario", "1234");

        // Strategy
        AuthStrategy strategy =
                new PasswordStrategy();

        AuthService authService =
                new AuthService(strategy);

        AuthResult result =
                authService.authenticate(credentials);

        // Chain of Responsibility
        CredentialValidator cred =
                new CredentialValidator();

        PermissionValidator perm =
                new PermissionValidator();

        LocationValidator loc =
                new LocationValidator();

        TimeValidator time =
                new TimeValidator();

        cred.setNext(perm)
                .setNext(loc)
                .setNext(time);

        try {
            cred.validate(result);

            System.out.println("Acceso concedido.");

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}