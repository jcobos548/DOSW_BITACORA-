package dosw.semana_4.patrones;

public class RejectedState implements DocumentState {

    @Override
    public void approve(Document document) {
        System.out.println("Un documento rechazado no puede aprobarse directamente.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("El documento ya está rechazado.");
    }

    @Override
    public String getName() {
        return "RECHAZADO";
    }
}