package dosw.semana_4.patrones;

public class LegalHandler extends DocumentHandler {

    @Override
    protected boolean canHandle(Document document) {
        return document.getState() instanceof ApprovedState;
    }

    @Override
    protected void process(Document document) {
        System.out.println("Revisión jurídica completada.");
        System.out.println("Documento aprobado definitivamente.");
    }
}
