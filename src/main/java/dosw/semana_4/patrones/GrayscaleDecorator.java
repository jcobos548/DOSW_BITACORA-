package dosw.semana_4.patrones;

public class GrayscaleDecorator extends ImageDecorator {

    public GrayscaleDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return image.render() + " + Blanco y Negro";
    }
}