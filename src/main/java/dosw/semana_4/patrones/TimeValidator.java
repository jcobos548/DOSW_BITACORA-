package dosw.semana_4.patrones;

public class TimeValidator extends Validator {

    @Override
    protected boolean check(AuthResult result) {
        System.out.println("Validando horario laboral...");
        return true;
    }
}