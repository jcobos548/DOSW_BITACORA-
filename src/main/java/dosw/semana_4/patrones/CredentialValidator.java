package dosw.semana_4.patrones;

public class CredentialValidator extends Validator {

    @Override
    protected boolean check(AuthResult result) {
        System.out.println("Validando credenciales...");
        return result.isAuthenticated();
    }
}
