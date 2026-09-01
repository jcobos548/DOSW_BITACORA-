package dosw.semana_4.patrones;

import java.util.function.Function;

public class ApplyFilterCommand implements ImageCommand {

    private Image image;
    private final Function<Image, Image> decorator;
    private Image previousImage;

    public ApplyFilterCommand(
            Image image,
            Function<Image, Image> decorator
    ) {
        this.image = image;
        this.decorator = decorator;
    }

    @Override
    public void execute() {
        previousImage = image;
        image = decorator.apply(image);
    }

    @Override
    public void undo() {
        if (previousImage != null) {
            image = previousImage;
        }
    }

    public Image getImage() {
        return image;
    }
}
