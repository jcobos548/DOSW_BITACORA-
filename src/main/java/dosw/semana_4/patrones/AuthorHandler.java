package dosw.semana_4.patrones;

public class AuthorHandler extends DocumentHandler {

    @Override
    protected boolean canHandle(Document document) {
        return document.getState() instanceof DraftState;
    }

    @Override
    protected void process(Document document) {
        System.out.println("Autor revisa el documento.");
        document.approve();
    }
}