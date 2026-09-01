package dosw.semana_4.patrones;

public class Content {

    private String title;
    private String genre;

    public Content(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title;
    }
}