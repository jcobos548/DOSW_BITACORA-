package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {

        List<String> words = List.of(
                "java",
                "stream",
                "api",
                "functional",
                "code",
                "git"
        );

        List<String> result = words.stream()
                .filter(word -> word.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(result);
        System.out.println("Cantidad de palabras resultantes: " + result.size());
    }
}