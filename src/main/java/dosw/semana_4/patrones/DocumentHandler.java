package dosw.semana_4.patrones;

public abstract class DocumentHandler {

    private DocumentHandler next;

    public DocumentHandler setNext(DocumentHandler next) {
        this.next = next;
        return next;
    }

    public void handle(Document document) {

        if (canHandle(document)) {
            process(document);
        } else if (next != null) {
            next.handle(document);
        } else {
            System.out.println(
                    "Ningún handler pudo procesar el documento."
            );
        }
    }

    protected abstract boolean canHandle(Document document);

    protected abstract void process(Document document);
}