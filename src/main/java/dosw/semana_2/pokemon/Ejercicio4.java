package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio4 {

    public static void main(String[] args) {

        record Pokemon(String nombre, int nivel) {}

        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", 45),
                new Pokemon("Charmander", 62),
                new Pokemon("Squirtle", 38),
                new Pokemon("Snorlax", 90),
                new Pokemon("Mewtwo", 88)
        );

        Pokemon pokemonAlfa = pokemones.stream()
                .max(Comparator.comparingInt(Pokemon::nivel))
                .orElseThrow();

        System.out.println(
                "Pokémon Alfa: " + pokemonAlfa.nombre()
                        + " (nivel " + pokemonAlfa.nivel() + ")"
        );
    }
}