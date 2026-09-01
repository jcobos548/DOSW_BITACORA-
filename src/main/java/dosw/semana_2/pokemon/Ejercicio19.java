package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio19 {

    public static void main(String[] args) {

        List<Pokemon> equipoGary = List.of(
                new Pokemon(1L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(2L, "Blastoise", "Agua", 65, 550, "Kanto", false),
                new Pokemon(3L, "Arcanine", "Fuego", 60, 560, "Kanto", false),
                new Pokemon(4L, "Alakazam", "Psíquico", 58, 550, "Kanto", false)
        );

        List<Pokemon> equipoAsh = List.of(
                new Pokemon(5L, "Pikachu", "Eléctrico", 45, 620, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(7L, "Dragonite", "Dragón", 82, 620, "Kanto", false)
        );

        List<Pokemon> equipoDawn = List.of(
                new Pokemon(8L, "Piplup", "Agua", 22, 700, "Sinnoh", false),
                new Pokemon(9L, "Empoleon", "Agua", 50, 700, "Sinnoh", false),
                new Pokemon(10L, "Togekiss", "Hada", 55, 700, "Sinnoh", false)
        );

        List<Pokemon> equipoBrock = List.of(
                new Pokemon(11L, "Onix", "Roca", 55, 450, "Kanto", false),
                new Pokemon(12L, "Geodude", "Roca", 35, 400, "Kanto", false),
                new Pokemon(13L, "Golem", "Roca", 60, 500, "Kanto", false),
                new Pokemon(14L, "Steelix", "Acero", 70, 320, "Johto", false)
        );

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Gary", 10, equipoGary),
                new Entrenador(2L, "Ash", 8, equipoAsh),
                new Entrenador(3L, "Dawn", 7, equipoDawn),
                new Entrenador(4L, "Brock", 6, equipoBrock)
        );

        entrenadores.stream()
                .sorted(
                        Comparator.comparingInt(Entrenador::getMedallas)
                                .reversed()
                                .thenComparing(
                                        entrenador -> entrenador.getEquipo().stream()
                                                .mapToDouble(Pokemon::getPoderCombate)
                                                .sum(),
                                        Comparator.reverseOrder()
                                )
                                .thenComparing(Entrenador::getNombre)
                )
                .limit(3)
                .forEach(entrenador -> {

                    double poder = entrenador.getEquipo().stream()
                            .mapToDouble(Pokemon::getPoderCombate)
                            .sum();

                    System.out.println(
                            "– " + entrenador.getNombre()
                                    + " – " + entrenador.getMedallas()
                                    + " medallas, PC: " + (int) poder
                    );
                });
    }
}