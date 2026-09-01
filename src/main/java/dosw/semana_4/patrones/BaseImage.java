package dosw.semana_4.patrones;

public class BaseImage implements Image {

    private final String name;

    public BaseImage(String name) {
        this.name = name;
    }

    @Override
    public String render() {
        return name;
    }
}