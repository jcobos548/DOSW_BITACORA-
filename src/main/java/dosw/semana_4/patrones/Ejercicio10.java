package dosw.semana_4.patrones;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio10 {

    public static void main(String[] args) {

        Image image = new BaseImage("Foto");

        List<ImageCommand> history = new ArrayList<>();

        // Aplicar Blanco y Negro
        ApplyFilterCommand grayscale =
                new ApplyFilterCommand(
                        image,
                        GrayscaleDecorator::new
                );

        grayscale.execute();
        image = grayscale.getImage();
        history.add(grayscale);

        System.out.println("Después de Blanco y Negro:");
        System.out.println(image.render());

        // Aplicar Sepia
        ApplyFilterCommand sepia =
                new ApplyFilterCommand(
                        image,
                        SepiaDecorator::new
                );

        sepia.execute();
        image = sepia.getImage();
        history.add(sepia);

        System.out.println("\nDespués de Sepia:");
        System.out.println(image.render());

        // Aplicar Brillo
        ApplyFilterCommand brightness =
                new ApplyFilterCommand(
                        image,
                        BrightnessDecorator::new
                );

        brightness.execute();
        image = brightness.getImage();
        history.add(brightness);

        System.out.println("\nDespués de Brillo:");
        System.out.println(image.render());

        // Undo individual del último filtro
        brightness.undo();
        image = brightness.getImage();

        System.out.println("\nDespués de deshacer Brillo:");
        System.out.println(image.render());
    }
}