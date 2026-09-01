package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio18 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Gengar", "Fantasma", 50, 495, "Kanto", false),
                new Pokemon(5L, "Charizard", "Fuego", 62, 610, "Kanto", false)
        );

        System.out.println("Top 5 Pokémon más fuertes:");

        pokemones.stream()
                .sorted((pokemon1, pokemon2) ->
                        Double.compare(
                                pokemon2.getPoderCombate(),
                                pokemon1.getPoderCombate()
                        ))
                .limit(5)
                .forEach(pokemon ->
                        System.out.println(
                                pokemon.getNombre()
                                        + " – PC: "
                                        + (int) pokemon.getPoderCombate()
                        ));
    }
}