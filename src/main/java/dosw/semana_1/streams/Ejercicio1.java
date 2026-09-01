package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(3, 8, 10, 12, 15, 18, 20);

        List<Integer> result = numbers.stream()
                .filter(number -> number > 10 && number % 2 == 0)
                .toList();

        System.out.println(result);
    }
}