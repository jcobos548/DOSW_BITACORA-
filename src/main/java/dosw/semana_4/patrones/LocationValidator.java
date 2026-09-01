package dosw.semana_4.patrones;

public class LocationValidator extends Validator {

    @Override
    protected boolean check(AuthResult result) {
        System.out.println("Validando ubicación...");
        return true;
    }
}