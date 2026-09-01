package dosw.semana_4.patrones;

public class PermissionValidator extends Validator {

    @Override
    protected boolean check(AuthResult result) {
        System.out.println("Validando permisos...");
        return true;
    }
}