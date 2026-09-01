package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio9 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle", "Agua", 38, 210, "Kanto", false),
                new Pokemon(5L, "Gengar", "Fantasma", 50, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 62, 610, "Kanto", false)
        );

        List<Pokemon> equipoElite = pokemones.stream()
                .filter(pokemon -> pokemon.getPoderCombate() > 500)
                .toList();

        System.out.println("Equipo Élite (PC > 500):");

        System.out.println(
                equipoElite.stream()
                        .map(pokemon -> pokemon.getNombre()
                                + "(" + (int) pokemon.getPoderCombate() + ")")
                        .toList()
        );
    }
}