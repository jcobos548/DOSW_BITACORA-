package dosw.semana_4.patrones;

public class SepiaDecorator extends ImageDecorator {

    public SepiaDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return image.render() + " + Sepia";
    }
}