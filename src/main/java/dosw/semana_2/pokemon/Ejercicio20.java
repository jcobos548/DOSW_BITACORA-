package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio20 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Gengar", "Fantasma", 50, 495, "Kanto", false),
                new Pokemon(5L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(6L, "Blastoise", "Agua", 65, 550, "Kanto", false),
                new Pokemon(7L, "Lugia", "Psíquico", 70, 650, "Johto", true),
                new Pokemon(8L, "Typhlosion", "Fuego", 58, 500, "Johto", false),
                new Pokemon(9L, "Feraligatr", "Agua", 55, 480, "Johto", false),
                new Pokemon(10L, "Meganium", "Planta", 60, 450, "Johto", false)
        );

        Map<String, Long> cantidadPorTipo = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.counting()
                ));

        Map<String, Long> cantidadPorRegion = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getRegion,
                        Collectors.counting()
                ));

        long legendarios = pokemones.stream()
                .filter(Pokemon::isLegendario)
                .count();

        double promedioNivel = pokemones.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0);

        Pokemon masFuerte = pokemones.stream()
                .max((pokemon1, pokemon2) ->
                        Double.compare(
                                pokemon1.getPoderCombate(),
                                pokemon2.getPoderCombate()
                        ))
                .orElseThrow();

        System.out.println("Por tipo: " + cantidadPorTipo);
        System.out.println("Por región: " + cantidadPorRegion);
        System.out.println("Legendarios: " + legendarios);
        System.out.printf("Promedio niv: %.1f%n", promedioNivel);
        System.out.println(
                "Más fuerte: " + masFuerte.getNombre()
                        + " (PC: " + (int) masFuerte.getPoderCombate() + ")"
        );
    }
}