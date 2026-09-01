package dosw.semana_4.patrones;

public interface DocumentState {

    void approve(Document document);

    void reject(Document document);

    String getName();
}