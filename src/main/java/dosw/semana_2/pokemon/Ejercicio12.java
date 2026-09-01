package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Comparator;

public class Ejercicio12 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Charizard", "Fuego", 62, 610, "Kanto", false)
        );

        Pokemon campeon = pokemones.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .orElseThrow();

        System.out.println(
                "Campeón: " + campeon.getNombre()
                        + " con PC: " + (int) campeon.getPoderCombate()
        );
    }
}