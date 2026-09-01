package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(2L, "Psyduck", "Agua", 33, 250, "Kanto", false),
                new Pokemon(3L, "Charmander", "Fuego", 45, 300, "Kanto", false),
                new Pokemon(4L, "Vulpix", "Fuego", 36, 270, "Kanto", false),
                new Pokemon(5L, "Bulbasaur", "Planta", 40, 280, "Kanto", false)
        );

        Map<String, List<String>> pokemonesPorTipo = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        pokemonesPorTipo.forEach((tipo, nombres) ->
                System.out.println(tipo + ": " + nombres)
        );
    }
}