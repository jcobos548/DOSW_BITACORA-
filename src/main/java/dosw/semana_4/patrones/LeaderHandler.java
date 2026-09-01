package dosw.semana_4.patrones;

public class LeaderHandler extends DocumentHandler {

    @Override
    protected boolean canHandle(Document document) {
        return document.getState() instanceof InReviewState;
    }

    @Override
    protected void process(Document document) {
        System.out.println("Líder revisa el documento.");
        document.approve();
    }
}