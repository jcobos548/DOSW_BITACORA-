package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu",
                "Charmander",
                "Squirtle",
                "Vulpix",
                "Bulbasaur",
                "Flareon"
        );

        List<String> pokemonesFuego = pokemones.stream()
                .filter(pokemon ->
                        pokemon.equals("Charmander") ||
                                pokemon.equals("Vulpix") ||
                                pokemon.equals("Flareon"))
                .toList();

        System.out.println(pokemonesFuego);
    }
}
