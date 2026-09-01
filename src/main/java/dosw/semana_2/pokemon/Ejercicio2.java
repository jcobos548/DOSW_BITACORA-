package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu",
                "Charmander",
                "Squirtle",
                "Bulbasaur"
        );

        List<String> nombresMayuscula = pokemones.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(nombresMayuscula);
    }
}