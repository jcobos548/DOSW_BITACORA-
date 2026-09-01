package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio5 {

    public static void main(String[] args) {

        record Pokemon(String nombre, int nivel) {}

        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", 45),
                new Pokemon("Mewtwo", 88),
                new Pokemon("Dragonite", 82),
                new Pokemon("Squirtle", 38),
                new Pokemon("Mew", 85),
                new Pokemon("Charmander", 62)
        );

        long cantidad = pokemones.stream()
                .filter(pokemon -> pokemon.nivel() > 80)
                .count();

        System.out.println("Pokémon con nivel > 80: " + cantidad);
        System.out.println("(Mewtwo, Dragonite, Mew)");
    }
}