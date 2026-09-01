package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio6 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu",
                "Charmander",
                "Pikachu",
                "Squirtle",
                "Charmander",
                "Mewtwo"
        );

        List<String> pokemonesSinDuplicados = pokemones.stream()
                .distinct()
                .toList();

        System.out.println(pokemonesSinDuplicados);
    }
}