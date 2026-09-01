package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio8 {

    public static void main(String[] args) {

        record Pokemon(String nombre, boolean puedeEvolucionar) {}

        List<Pokemon> pokemones = List.of(
                new Pokemon("Pikachu", true),
                new Pokemon("Raichu", false),
                new Pokemon("Charmander", true),
                new Pokemon("Charizard", false),
                new Pokemon("Squirtle", true),
                new Pokemon("Blastoise", false)
        );

        List<String> listosParaEvolucionar = pokemones.stream()
                .filter(Pokemon::puedeEvolucionar)
                .map(Pokemon::nombre)
                .toList();

        System.out.println("Listos para evolucionar:");
        System.out.println(listosParaEvolucionar);
    }
}