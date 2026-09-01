package dosw.semana_4.patrones;

public class Document {

    private final String title;
    private DocumentState state;

    public Document(String title) {
        this.title = title;
        this.state = new DraftState();
    }

    public String getTitle() {
        return title;
    }

    public DocumentState getState() {
        return state;
    }

    public void setState(DocumentState state) {
        this.state = state;
        System.out.println("Estado cambiado a: " + state.getName());
    }

    public void approve() {
        state.approve(this);
    }

    public void reject() {
        state.reject(this);
    }
}
