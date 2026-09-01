package dosw.semana_4.patrones;

public class BrightnessDecorator extends ImageDecorator {

    public BrightnessDecorator(Image image) {
        super(image);
    }

    @Override
    public String render() {
        return image.render() + " + Brillo";
    }
}