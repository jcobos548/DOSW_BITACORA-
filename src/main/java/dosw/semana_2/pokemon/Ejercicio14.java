package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio14 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Chikorita", "Planta", 20, 200, "Johto", false),
                new Pokemon(3L, "Torchic", "Fuego", 25, 250, "Hoenn", false),
                new Pokemon(4L, "Piplup", "Agua", 22, 230, "Sinnoh", false),
                new Pokemon(5L, "Charmander", "Fuego", 40, 300, "Kanto", false),
                new Pokemon(6L, "Totodile", "Agua", 21, 220, "Johto", false)
        );

        Map<String, List<String>> pokemonesPorRegion = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getRegion,
                        Collectors.mapping(
                                Pokemon::getNombre,
                                Collectors.toList()
                        )
                ));

        pokemonesPorRegion.forEach((region, nombres) ->
                System.out.println(region + ": " + nombres)
        );
    }
}