package dosw.semana_4.patrones;

public class DraftState implements DocumentState {

    @Override
    public void approve(Document document) {
        System.out.println("El documento pasa a revisión.");
        document.setState(new InReviewState());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Un documento en borrador no puede ser rechazado.");
    }

    @Override
    public String getName() {
        return "BORRADOR";
    }
}
