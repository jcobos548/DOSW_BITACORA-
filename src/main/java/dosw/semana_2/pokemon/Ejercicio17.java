package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio17 {

    public static void main(String[] args) {

        List<Pokemon> equipoAsh = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 620, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 620, "Kanto", false)
        );

        List<Pokemon> equipoGary = List.of(
                new Pokemon(4L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(5L, "Blastoise", "Agua", 65, 550, "Kanto", false),
                new Pokemon(6L, "Arcanine", "Fuego", 60, 560, "Kanto", false),
                new Pokemon(7L, "Alakazam", "Psíquico", 58, 550, "Kanto", false)
        );

        List<Pokemon> equipoBrock = List.of(
                new Pokemon(8L, "Onix", "Roca", 55, 450, "Kanto", false),
                new Pokemon(9L, "Geodude", "Roca", 35, 400, "Kanto", false),
                new Pokemon(10L, "Golem", "Roca", 60, 500, "Kanto", false),
                new Pokemon(11L, "Steelix", "Acero", 70, 320, "Johto", false)
        );

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, equipoAsh),
                new Entrenador(2L, "Gary", 10, equipoGary),
                new Entrenador(3L, "Brock", 6, equipoBrock)
        );

        Entrenador entrenadorMasPoderoso = entrenadores.stream()
                .max(Comparator.comparingDouble(entrenador ->
                        entrenador.getEquipo().stream()
                                .mapToDouble(Pokemon::getPoderCombate)
                                .sum()
                ))
                .orElseThrow();

        double poderAcumulado = entrenadorMasPoderoso.getEquipo().stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum();

        System.out.println("Entrenador más poderoso: "
                + entrenadorMasPoderoso.getNombre());

        System.out.println("Poder acumulado del equipo: "
                + (int) poderAcumulado);
    }
}