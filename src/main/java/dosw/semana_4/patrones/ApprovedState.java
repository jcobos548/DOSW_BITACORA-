package dosw.semana_4.patrones;

public class ApprovedState implements DocumentState {

    @Override
    public void approve(Document document) {
        System.out.println("El documento ya está aprobado.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Un documento aprobado no puede volver a rechazarse.");
    }

    @Override
    public String getName() {
        return "APROBADO";
    }
}