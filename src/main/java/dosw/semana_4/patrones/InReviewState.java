package dosw.semana_4.patrones;

public class InReviewState implements DocumentState {

    @Override
    public void approve(Document document) {
        System.out.println("El documento ha sido aprobado.");
        document.setState(new ApprovedState());
    }

    @Override
    public void reject(Document document) {
        System.out.println("El documento ha sido rechazado.");
        document.setState(new RejectedState());
    }

    @Override
    public String getName() {
        return "EN REVISIÓN";
    }
}