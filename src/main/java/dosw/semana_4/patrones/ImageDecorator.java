package dosw.semana_4.patrones;

public abstract class ImageDecorator implements Image {

    protected Image image;

    public ImageDecorator(Image image) {
        this.image = image;
    }

    public Image getWrapped() {
        return image;
    }
}