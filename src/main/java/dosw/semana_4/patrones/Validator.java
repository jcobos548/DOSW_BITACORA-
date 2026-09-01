package dosw.semana_4.patrones;

public abstract class Validator {

    private Validator next;

    public Validator setNext(Validator next) {
        this.next = next;
        return next;
    }

    public void validate(AuthResult result) {

        if (!check(result)) {
            throw new IllegalStateException(
                    "Acceso denegado."
            );
        }

        if (next != null) {
            next.validate(result);
        }
    }

    protected abstract boolean check(AuthResult result);
}
