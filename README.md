# DOSW_BITACORA-

# SEMANA No 1 — DOSW Manejo de Streams

## Datos personales:
- Nombre y Apellido: Julian Giral
- Código de Estudiante: 1000100073
- Curso: DOSW GRUPO1

---

### Ejercicio 01 — Números Pares mayores a diez

Dada una lista de números enteros, necesitamos obtener una nueva lista solo con los números pares mayores a 10.

**Código implementado:**

```java
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
```

**Captura de ejecución:**

<!-- Pegar aquí la captura de ejecución del Ejercicio 1 -->

**Explicación:**

Se utiliza un Stream sobre la lista de números y `filter()` para conservar únicamente los números mayores a 10 que además sean pares. El resultado obtenido es `[12, 18, 20]`.

---

### Ejercicio 02 — Cantidad de Palabras con más de 4 caracteres

Dada una lista de palabras, se requiere filtrar las palabras que tengan más de 4 caracteres, convertirlas en mayúsculas, ordenarlas alfabéticamente y obtener la cantidad total de palabras resultantes.

**Código implementado:**

```java
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
```

**Captura de ejecución:**

<!-- Pegar aquí la captura de ejecución del Ejercicio 2 -->

**Explicación:**

Se utiliza `filter()` para seleccionar las palabras que tienen más de cuatro caracteres. Luego, `map()` las convierte a mayúsculas y `sorted()` las ordena alfabéticamente. Finalmente, se obtiene la cantidad de palabras utilizando `size()`. El resultado es `[FUNCTIONAL, STREAM]` y la cantidad de palabras resultantes es 2.

---

### Ejercicio 03 — Obtener nombres de los Usuarios

Dada una lista de usuarios con los atributos `id`, `name`, `age` y `active`, se deben filtrar únicamente los usuarios activos, obtener una lista con sus nombres en mayúscula y ordenarlos alfabéticamente.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio3 {

    public static class User {
        private int id;
        private String name;
        private int age;
        private boolean active;

        public User(int id, String name, int age, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public boolean isActive() {
            return active;
        }
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Carlos", 20, true),
                new User(2, "Ana", 25, false),
                new User(3, "Pedro", 30, true),
                new User(4, "Maria", 22, true),
                new User(5, "Luis", 28, false)
        );

        List<String> sortedUsers = users.stream()
                .filter(User::isActive)
                .map(User::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(sortedUsers);
    }
}
```

**Captura de ejecución:**

<!-- Pegar aquí la captura de ejecución del Ejercicio 3 -->

**Explicación:**

Se utiliza `filter()` para seleccionar únicamente los usuarios activos. Después, `map()` permite obtener sus nombres y convertirlos a mayúsculas. Finalmente, `sorted()` organiza los nombres alfabéticamente. El resultado obtenido es `[CARLOS, MARIA, PEDRO]`.

---

### Ejercicio 04 — Personas mayores de edad

Dado un listado de usuarios y utilizando los mismos atributos anteriores, se deben filtrar las personas mayores de edad y obtener sus nombres.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio4 {

    public static class User {
        private int id;
        private String name;
        private int age;
        private boolean active;

        public User(int id, String name, int age, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Carlos", 17, true),
                new User(2, "Ana", 25, true),
                new User(3, "Pedro", 18, false),
                new User(4, "Maria", 30, true),
                new User(5, "Luis", 15, true)
        );

        List<String> adults = users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .toList();

        System.out.println(adults);
    }
}
```

**Captura de ejecución:**

<!-- Pegar aquí la captura de ejecución del Ejercicio 4 -->

**Explicación:**

Se utiliza `filter()` para seleccionar los usuarios cuya edad sea mayor o igual a 18 años. Después, mediante `map()` se obtienen únicamente sus nombres. El resultado obtenido es `[Ana, Pedro, Maria]`.

---

### Ejercicio 05 — Transacciones Bancarias

Dada una lista de transacciones bancarias representadas por objetos con los atributos `id`, `amount` y `approved`, se requiere procesar la lista utilizando Streams. Se debe utilizar `peek()` para observar cada transacción procesada y `anyMatch()` para verificar si existe al menos una transacción no aprobada. Finalmente, se debe retornar `true` o `false` indicando si el lote de transacciones es válido.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio5 {

    static class Transaction {
        private String id;
        private double amount;
        private boolean approved;

        public Transaction(String id, double amount, boolean approved) {
            this.id = id;
            this.amount = amount;
            this.approved = approved;
        }

        public boolean isApproved() {
            return approved;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id='" + id + '\'' +
                    ", amount=" + amount +
                    ", approved=" + approved +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("T001", 150.0, true),
                new Transaction("T002", 300.0, true),
                new Transaction("T003", 75.0, false),
                new Transaction("T004", 500.0, true)
        );

        boolean hasNotApproved = transactions.stream()
                .peek(transaction -> System.out.println(
                        "Procesando: " + transaction))
                .anyMatch(transaction -> !transaction.isApproved());

        boolean valid = !hasNotApproved;

        System.out.println("¿Lote válido? " + valid);
    }
}
```

**Captura de ejecución:**

<!-- Pegar aquí la captura de ejecución del Ejercicio 5 -->

**Explicación:**

Se utiliza `peek()` para mostrar en consola cada transacción procesada. Luego, `anyMatch()` verifica si existe al menos una transacción que no haya sido aprobada. Como la transacción `T003` no está aprobada, el resultado de `anyMatch()` es `true`, por lo que el lote de transacciones se considera inválido y se muestra `false`.

---

## Conclusión

Durante esta semana se trabajó con los conceptos básicos de programación funcional en Java utilizando Streams y expresiones Lambda. Se utilizaron operaciones como `filter()`, `map()`, `sorted()`, `peek()` y `anyMatch()` para procesar colecciones de datos de manera funcional, evitando ciclos tradicionales y recorridos imperativos.

---

# SEMANA No 2 

## Datos de Entrenador

- **Nombre y Apellido:** Julian Giral
- **Código de Estudiante:** 1000100073
- **Curso:** DOSW GRUPO 1

---

# Nivel 1 — Entrenador Novato

## Ejercicio 01 — Maestro del Fuego

### Enunciado

Dada una lista de Pokémon con su nombre y tipo, obtener únicamente los Pokémon cuyo tipo sea Fuego.

### Operación utilizada

`filter()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Charmander", "Fuego", 39, 309, "Kanto", false),
                new Pokemon(2L, "Vulpix", "Fuego", 38, 299, "Kanto", false),
                new Pokemon(3L, "Squirtle", "Agua", 44, 314, "Kanto", false),
                new Pokemon(4L, "Flareon", "Fuego", 65, 525, "Kanto", false)
        );

        pokemones.stream()
                .filter(pokemon -> pokemon.getTipo().equals("Fuego"))
                .map(Pokemon::getNombre)
                .forEach(System.out::println);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 01](...)

### Explicación

Se utiliza `filter()` para seleccionar únicamente los Pokémon cuyo tipo es Fuego. Después se utiliza `map()` para obtener sus nombres.

---

## Ejercicio 02 — Pokédex Gritona

### Enunciado

Transformar todos los nombres de Pokémon a mayúsculas.

### Operación utilizada

`map()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu",
                "Charmander",
                "Bulbasaur",
                "Squirtle"
        );

        pokemones.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 02](...)

### Explicación

Se utiliza `map()` para transformar cada nombre de Pokémon a mayúsculas.

---

## Ejercicio 03 — Poder Total del Equipo

### Enunciado

Dada una lista de niveles de Pokémon, calcular la suma total de niveles del equipo.

### Operación utilizada

`reduce()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {

        List<Integer> niveles = List.of(50, 60, 70, 80);

        int suma = niveles.stream()
                .reduce(0, Integer::sum);

        System.out.println("Suma total de niveles: " + suma);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 03](...)

### Explicación

Se utiliza `reduce()` para acumular todos los niveles y obtener la suma total.

---

## Ejercicio 04 — Pokémon Alfa

### Enunciado

Encontrar el Pokémon con el nivel más alto dentro del equipo.

### Operación utilizada

`max(Comparator)`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio4 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 80, 610, "Kanto", false),
                new Pokemon(3L, "Bulbasaur", "Planta", 40, 300, "Kanto", false)
        );

        Pokemon mayorNivel = pokemones.stream()
                .max(Comparator.comparingInt(Pokemon::getNivel))
                .orElseThrow();

        System.out.println("Pokémon con mayor nivel: " + mayorNivel.getNombre());
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 04](...)

### Explicación

Se utiliza `max(Comparator)` para comparar los niveles y obtener el Pokémon que tiene el nivel más alto.

---

## Ejercicio 05 — Pokémon Legendarios

### Enunciado

Contar cuántos Pokémon del equipo tienen nivel superior a 80.

### Operación utilizada

`filter() + count()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio5 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 50, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo", "Psíquico", 90, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón", 85, 530, "Kanto", false),
                new Pokemon(4L, "Charmander", "Fuego", 40, 309, "Kanto", false)
        );

        long cantidad = pokemones.stream()
                .filter(pokemon -> pokemon.getNivel() > 80)
                .count();

        System.out.println("Pokémon con nivel superior a 80: " + cantidad);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 05](...)

### Explicación

Se utiliza `filter()` para seleccionar los Pokémon con nivel superior a 80 y `count()` para contar cuántos cumplen la condición.

---

# Nivel 2 — Entrenador Intermedio

## Ejercicio 06 — Pokédex Sin Duplicados

### Enunciado

Dada una lista de Pokémon con elementos repetidos, generar una nueva colección donde cada Pokémon aparezca una sola vez.

### Operación utilizada

`distinct()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio6 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu",
                "Charmander",
                "Pikachu",
                "Bulbasaur",
                "Charmander"
        );

        pokemones.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 06](...)

### Explicación

Se utiliza `distinct()` para eliminar los nombres repetidos y conservar únicamente una aparición de cada Pokémon.

---

## Ejercicio 07 — Orden del Profesor Oak

### Enunciado

Ordenar alfabéticamente los nombres de los Pokémon.

### Operación utilizada

`sorted()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio7 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu",
                "Charmander",
                "Bulbasaur",
                "Squirtle"
        );

        pokemones.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 07](...)

### Explicación

Se utiliza `sorted()` para ordenar alfabéticamente los nombres de los Pokémon.

---

## Ejercicio 08 — Evoluciones Preparadas

### Enunciado

Obtener únicamente los Pokémon que estén listos para evolucionar.

### Operación utilizada

`filter()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio8 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Charmander", "Fuego", 39, 309, "Kanto", false),
                new Pokemon(2L, "Bulbasaur", "Planta", 45, 318, "Kanto", false),
                new Pokemon(3L, "Squirtle", "Agua", 44, 314, "Kanto", false)
        );

        pokemones.stream()
                .filter(pokemon -> pokemon.getNivel() >= 40)
                .map(Pokemon::getNombre)
                .forEach(System.out::println);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 08](...)

### Explicación

Se utiliza `filter()` para seleccionar los Pokémon que cumplen la condición establecida para estar listos para evolucionar.

---

# Nivel 3 — Líder de Gimnasio

## Ejercicio 09 — Equipo Élite

### Enunciado

Mostrar únicamente los Pokémon cuyo `poderCombate` sea superior a 500.

### Operación utilizada

`filter()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio9 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(4L, "Gengar", "Fantasma", 50, 495, "Kanto", false)
        );

        pokemones.stream()
                .filter(pokemon -> pokemon.getPoderCombate() > 500)
                .map(Pokemon::getNombre)
                .forEach(System.out::println);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 09](...)

### Explicación

Se utiliza `filter()` para seleccionar únicamente los Pokémon cuyo poder de combate es superior a 500.

---

## Ejercicio 10 — Pokédex Compacta

### Enunciado

Generar una lista que contenga únicamente los nombres de todos los Pokémon del equipo.

### Operación utilizada

`map() + collect()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Bulbasaur", "Planta", 45, 318, "Kanto", false)
        );

        List<String> nombres = pokemones.stream()
                .map(Pokemon::getNombre)
                .collect(Collectors.toList());

        System.out.println(nombres);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 10](...)

### Explicación

Se utiliza `map()` para obtener únicamente los nombres y `collect()` para convertir el resultado en una lista.

---

## Ejercicio 11 — Poder Promedio

### Enunciado

Calcular el promedio de `poderCombate` de todos los Pokémon del equipo.

### Operación utilizada

`mapToDouble() + average()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio11 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Blastoise", "Agua", 65, 550, "Kanto", false)
        );

        double promedio = pokemones.stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .average()
                .orElse(0);

        System.out.println("Poder promedio: " + promedio);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 11](...)

### Explicación

Se utiliza `mapToDouble()` para obtener los valores de poder de combate y `average()` para calcular su promedio.

---

## Ejercicio 12 — Campeón Regional

### Enunciado

Obtener el Pokémon con mayor `poderCombate` de toda la lista.

### Operación utilizada

`max(Comparator)`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio12 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true)
        );

        Pokemon masFuerte = pokemones.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .orElseThrow();

        System.out.println("Pokémon más fuerte: " + masFuerte.getNombre());
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 12](...)

### Explicación

Se utiliza `max(Comparator)` para comparar el poder de combate y obtener el Pokémon con el valor más alto.

---

## Ejercicio 13 — Organizar por Tipo

### Enunciado

Agrupar todos los Pokémon por su tipo y mostrar el listado por grupo.

### Operación utilizada

`groupingBy()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Charmander", "Fuego", 39, 309, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Squirtle", "Agua", 44, 314, "Kanto", false),
                new Pokemon(4L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false)
        );

        Map<String, List<Pokemon>> porTipo = pokemones.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo));

        porTipo.forEach((tipo, lista) ->
                System.out.println(tipo + ": " +
                        lista.stream()
                                .map(Pokemon::getNombre)
                                .toList())
        );
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 13](...)

### Explicación

Se utiliza `groupingBy()` para agrupar los Pokémon según su tipo.

---

## Ejercicio 14 — Organizar por Región

### Enunciado

Agrupar los Pokémon según su región de origen.

### Operación utilizada

`groupingBy()`

### Código implementado

~~~java
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
~~~

### Captura de ejecución

![Ejecución Ejercicio 14](...)

### Explicación

Se utiliza `groupingBy()` para agrupar los Pokémon según su región de origen.

---

# Nivel 4 — Alto Mando

## Ejercicio 15 — Maestro de Gimnasios

### Enunciado

Dado un listado de entrenadores con sus medallas, encontrar el entrenador con más medallas.

### Operación utilizada

`max(Comparator)`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio15 {

    public static void main(String[] args) {

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, List.of()),
                new Entrenador(2L, "Misty", 5, List.of()),
                new Entrenador(3L, "Brock", 6, List.of()),
                new Entrenador(4L, "Gary", 10, List.of())
        );

        Entrenador campeon = entrenadores.stream()
                .max(Comparator.comparingInt(Entrenador::getMedallas))
                .orElseThrow();

        System.out.println("Campeón de gimnasios: " + campeon.getNombre());
        System.out.println("Medallas obtenidas: " + campeon.getMedallas());
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 15](...)

### Explicación

Se utiliza `max(Comparator)` para encontrar el entrenador con mayor cantidad de medallas.

---

## Ejercicio 16 — Entrenadores Experimentados

### Enunciado

Mostrar únicamente los entrenadores que posean más de 5 medallas.

### Operación utilizada

`filter()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;

public class Ejercicio16 {

    public static void main(String[] args) {

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, List.of()),
                new Entrenador(2L, "Misty", 5, List.of()),
                new Entrenador(3L, "Brock", 6, List.of()),
                new Entrenador(4L, "Gary", 10, List.of()),
                new Entrenador(5L, "May", 3, List.of()),
                new Entrenador(6L, "Dawn", 7, List.of())
        );

        List<String> experimentados = entrenadores.stream()
                .filter(entrenador -> entrenador.getMedallas() > 5)
                .map(entrenador ->
                        entrenador.getNombre() + "(" +
                        entrenador.getMedallas() + ")")
                .toList();

        System.out.println("Entrenadores con > 5 medallas:");
        System.out.println(experimentados);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 16](...)

### Explicación

Se utiliza `filter()` para seleccionar los entrenadores que poseen más de 5 medallas y `map()` para mostrar sus nombres.

---

## Ejercicio 17 — Equipo Más Poderoso

### Enunciado

Calcular cuál entrenador tiene la suma total de `poderCombate` más alta entre todos sus Pokémon.

### Operación utilizada

`mapToDouble() + sum()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;

public class Ejercicio17 {

    public static void main(String[] args) {

        List<Pokemon> equipoAsh = List.of(
                new Pokemon(1L, "Pikachu", "Eléctrico", 45, 620, "Kanto", false),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 620, "Kanto", false)
        );

        List<Pokemon> equipoGary = List.of(
                new Pokemon(4L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(5L, "Blastoise", "Agua", 65, 550, "Kanto", false),
                new Pokemon(6L, "Arcanine", "Fuego", 60, 560, "Kanto", false),
                new Pokemon(7L, "Alakazam", "Psíquico", 58, 550, "Kanto", false)
        );

        List<Pokemon> equipoBrock = List.of(
                new Pokemon(8L, "Onix", "Roca", 55, 450, "Kanto", false),
                new Pokemon(9L, "Geodude", "Roca", 35, 400, "Kanto", false),
                new Pokemon(10L, "Golem", "Roca", 60, 500, "Kanto", false),
                new Pokemon(11L, "Steelix", "Acero", 70, 320, "Johto", false)
        );

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash", 8, equipoAsh),
                new Entrenador(2L, "Gary", 10, equipoGary),
                new Entrenador(3L, "Brock", 6, equipoBrock)
        );

        Entrenador entrenadorMasPoderoso = entrenadores.stream()
                .max(Comparator.comparingDouble(entrenador ->
                        entrenador.getEquipo().stream()
                                .mapToDouble(Pokemon::getPoderCombate)
                                .sum()
                ))
                .orElseThrow();

        double poderAcumulado = entrenadorMasPoderoso.getEquipo().stream()
                .mapToDouble(Pokemon::getPoderCombate)
                .sum();

        System.out.println("Entrenador más poderoso: "
                + entrenadorMasPoderoso.getNombre());

        System.out.println("Poder acumulado del equipo: "
                + (int) poderAcumulado);
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 17](...)

### Explicación

Se utiliza `mapToDouble()` para obtener el poder de combate de cada Pokémon y `sum()` para calcular el poder acumulado del equipo. Después se utiliza `max()` para encontrar el entrenador con mayor poder acumulado.

---

# Nivel 5 — Campeón de la Liga Pokémon DOSW

## Ejercicio 18 — Top 5 Pokémon Más Fuertes

### Enunciado

Generar un ranking de los cinco Pokémon con mayor `poderCombate` de toda la Pokédex.

### Operación utilizada

`sorted() + limit(5)`

### Código implementado

~~~java
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
~~~

### Captura de ejecución

![Ejecución Ejercicio 18](...)

### Explicación

Se utiliza `sorted()` para ordenar los Pokémon de mayor a menor poder de combate y `limit(5)` para obtener los cinco primeros.

---

## Ejercicio 19 — Top 3 Entrenadores

### Enunciado

Generar un ranking de los 3 mejores entrenadores considerando más medallas, mayor poder acumulado y orden alfabético como criterio de desempate.

### Operación utilizada

`sorted() + limit(3)`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio19 {

    public static void main(String[] args) {

        List<Pokemon> equipoGary = List.of(
                new Pokemon(1L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(2L, "Blastoise", "Agua", 65, 550, "Kanto", false),
                new Pokemon(3L, "Arcanine", "Fuego", 60, 560, "Kanto", false),
                new Pokemon(4L, "Alakazam", "Psíquico", 58, 550, "Kanto", false)
        );

        List<Pokemon> equipoAsh = List.of(
                new Pokemon(5L, "Pikachu", "Eléctrico", 45, 620, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(7L, "Dragonite", "Dragón", 82, 620, "Kanto", false)
        );

        List<Pokemon> equipoDawn = List.of(
                new Pokemon(8L, "Piplup", "Agua", 22, 700, "Sinnoh", false),
                new Pokemon(9L, "Empoleon", "Agua", 50, 700, "Sinnoh", false),
                new Pokemon(10L, "Togekiss", "Hada", 55, 700, "Sinnoh", false)
        );

        List<Pokemon> equipoBrock = List.of(
                new Pokemon(11L, "Onix", "Roca", 55, 450, "Kanto", false),
                new Pokemon(12L, "Geodude", "Roca", 35, 400, "Kanto", false),
                new Pokemon(13L, "Golem", "Roca", 60, 500, "Kanto", false),
                new Pokemon(14L, "Steelix", "Acero", 70, 320, "Johto", false)
        );

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Gary", 10, equipoGary),
                new Entrenador(2L, "Ash", 8, equipoAsh),
                new Entrenador(3L, "Dawn", 7, equipoDawn),
                new Entrenador(4L, "Brock", 6, equipoBrock)
        );

        AtomicInteger posicion = new AtomicInteger(1);

        entrenadores.stream()
                .sorted(
                        Comparator.comparingInt(Entrenador::getMedallas)
                                .reversed()
                                .thenComparing(
                                        entrenador -> entrenador.getEquipo().stream()
                                                .mapToDouble(Pokemon::getPoderCombate)
                                                .sum(),
                                        Comparator.reverseOrder()
                                )
                                .thenComparing(Entrenador::getNombre)
                )
                .limit(3)
                .forEach(entrenador -> {

                    double poder = entrenador.getEquipo().stream()
                            .mapToDouble(Pokemon::getPoderCombate)
                            .sum();

                    System.out.println(
                            "#" + posicion.getAndIncrement()
                                    + " " + entrenador.getNombre()
                                    + " – " + entrenador.getMedallas()
                                    + " medallas, PC: " + (int) poder
                    );
                });
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 19](...)

### Explicación

Se utiliza `sorted()` con varios criterios de comparación y `limit(3)` para obtener los tres mejores entrenadores.

---

## Ejercicio 20 — Pokédex Analítica

### Enunciado

Construir una estructura que muestre la cantidad de Pokémon por tipo, por región, cantidad de legendarios, promedio de nivel y el Pokémon más fuerte.

### Operación utilizada

`groupingBy() + counting()`

### Código implementado

~~~java
package dosw.semana_2.pokemon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio20 {

    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Mewtwo", "Psíquico", 88, 680, "Kanto", true),
                new Pokemon(2L, "Charizard", "Fuego", 62, 610, "Kanto", false),
                new Pokemon(3L, "Dragonite", "Dragón", 82, 530, "Kanto", false),
                new Pokemon(4L, "Gengar", "Fantasma", 50, 495, "Kanto", false),
                new Pokemon(5L, "Pikachu", "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(6L, "Blastoise", "Agua", 65, 550, "Kanto", false),
                new Pokemon(7L, "Lugia", "Psíquico", 70, 650, "Johto", true),
                new Pokemon(8L, "Typhlosion", "Fuego", 58, 500, "Johto", false),
                new Pokemon(9L, "Feraligatr", "Agua", 55, 480, "Johto", false),
                new Pokemon(10L, "Meganium", "Planta", 60, 450, "Johto", false)
        );

        Map<String, Long> cantidadPorTipo = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.counting()
                ));

        Map<String, Long> cantidadPorRegion = pokemones.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getRegion,
                        Collectors.counting()
                ));

        long legendarios = pokemones.stream()
                .filter(Pokemon::isLegendario)
                .count();

        double promedioNivel = pokemones.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0);

        Pokemon masFuerte = pokemones.stream()
                .max((pokemon1, pokemon2) ->
                        Double.compare(
                                pokemon1.getPoderCombate(),
                                pokemon2.getPoderCombate()
                        ))
                .orElseThrow();

        System.out.println("Por tipo: " + cantidadPorTipo);
        System.out.println("Por región: " + cantidadPorRegion);
        System.out.println("Legendarios: " + legendarios);
        System.out.printf("Promedio niv: %.1f%n", promedioNivel);
        System.out.println(
                "Más fuerte: " + masFuerte.getNombre()
                        + " (PC: " + (int) masFuerte.getPoderCombate() + ")"
        );
    }
}
~~~

### Captura de ejecución

![Ejecución Ejercicio 20](...)

### Explicación

Se utilizan Streams para agrupar y contar los Pokémon por tipo y región mediante `groupingBy()` y `counting()`. También se cuentan los Pokémon legendarios, se calcula el promedio de nivel y se obtiene el Pokémon con mayor poder de combate.

---

# Retos Especiales

## Reto Legendario — Method References

- [x] Uso de Method References.
- [x] `Pokemon::getNombre`
- [x] `Pokemon::getTipo`
- [x] `Pokemon::getRegion`
- [x] `Pokemon::getPoderCombate`
- [x] `Entrenador::getMedallas`
- [x] `Entrenador::getNombre`

Los Method References permiten utilizar directamente métodos existentes dentro de las operaciones de Streams, haciendo el código más limpio y legible.

---

## Reto Shiny — Buenas prácticas de commits

- [x] Cada ejercicio fue desarrollado en su propia rama.
- [x] Se realizaron commits descriptivos.
- [x] Cada rama de ejercicio fue integrada a `feature/semana-2-dosw`.
- [x] Las ramas individuales fueron eliminadas después del merge.
- [x] La rama semanal se conserva como evidencia del desarrollo.

---

## Reto Mewtwo — Ejercicio Propuesto

- [ ] Pendiente de realizar.

---

# Conclusión

Durante la Semana 2 se practicaron diferentes operaciones de Streams de Java, incluyendo `filter()`, `map()`, `reduce()`, `sorted()`, `distinct()`, `max()`, `groupingBy()`, `counting()`, `mapToDouble()`, `average()`, `sum()` y `limit()`.

Los ejercicios permitieron practicar programación funcional, expresiones Lambda y Method References, buscando soluciones más limpias y mantenibles mediante Streams.

También se aplicó un flujo de Git organizado, trabajando cada ejercicio en una rama independiente y realizando posteriormente su integración a la rama semanal.

---

# Semana 4 — Taller #4 DOSW

## Descripción

Durante esta semana se desarrollaron los ejercicios correspondientes al Taller #4 de Desarrollo Orientado a Software (DOSW). En los ejercicios se aplicaron diferentes patrones de diseño, combinándolos en soluciones orientadas a problemas reales de software.

Los patrones trabajados fueron:

- Strategy
- Observer
- Chain of Responsibility
- State
- Builder
- Decorator
- Command
- Facade
- Adapter

---

## Ejercicio 1 — Plataforma de Pagos Inteligentes

### Patrones utilizados
- [Patrón 1]
- [Patrón 2]

### Descripción
Se desarrolló una solución aplicando los patrones de diseño solicitados en el taller, siguiendo el esquema de clases propuesto.

### Implementación
La solución se organizó mediante clases y responsabilidades separadas, buscando mantener un bajo acoplamiento y facilitar la extensión del sistema.

---

## Ejercicio 2 — Sistema de Notificaciones Multicanal

### Patrones utilizados
- [Patrón 1]
- [Patrón 2]

### Descripción
Se implementó el problema planteado utilizando los patrones de diseño indicados en el taller.

### Implementación
Las responsabilidades fueron distribuidas entre las diferentes clases de acuerdo con el patrón correspondiente.

---

## Ejercicio 3 — Sistema de Reportes Empresariales

### Patrones utilizados
- [Patrón 1]
- [Patrón 2]

### Descripción
Se desarrolló la solución propuesta en el taller utilizando los patrones de diseño correspondientes.

### Implementación
Se siguió la estructura de clases sugerida, separando las responsabilidades de cada componente.

---

## Ejercicio 4 — Plataforma de Videojuegos — Personajes

### Patrones utilizados
- [Patrón 1]
- [Patrón 2]

### Descripción
Se implementó el escenario planteado aplicando los patrones de diseño solicitados.

### Implementación
La solución permite separar las responsabilidades y facilita la interacción entre los diferentes componentes del sistema.

---

## Ejercicio 5 — Sistema de Pagos Bancarios

### Patrones utilizados
- Adapter
- Facade

### Descripción
Se desarrolló un sistema de procesamiento de pagos que permite utilizar un servicio bancario antiguo mediante una interfaz moderna y sencilla.

### Implementación

El patrón **Adapter** permite adaptar `LegacyBankService` a la interfaz `PaymentProcessor`, realizando la conversión del monto de dólares a centavos y traduciendo la operación de pago al método utilizado por el sistema bancario antiguo.

El patrón **Facade** simplifica el proceso completo de pago, ocultando los diferentes pasos necesarios para inicializar la conexión, iniciar la sesión, verificar la cuenta, preparar la transacción, procesarla y cerrar la sesión.

La interacción principal es:

`BankFacade → LegacyBankAdapter → LegacyBankService`

---

## Ejercicio 6 — Motor de Recomendaciones

### Patrones utilizados
- Strategy
- Observer

### Descripción
Se desarrolló un motor de recomendaciones que permite cambiar el algoritmo utilizado para generar recomendaciones y actualizar automáticamente los componentes interesados cuando cambian las preferencias del usuario.

### Implementación

El patrón **Strategy** permite definir diferentes algoritmos de recomendación mediante la interfaz `RecommendationAlgorithm`. Se implementaron estrategias como `GenreStrategy` y `PopularityStrategy`.

El patrón **Observer** permite que diferentes componentes sean notificados cuando el usuario cambia sus preferencias.

La interacción principal es:

`UserProfile → PreferenceObserver → HomePageComponent / SuggestedListComponent`

---

## Ejercicio 7 — Flujo de Aprobación de Documentos

### Patrones utilizados
- Chain of Responsibility
- State

### Descripción
Se desarrolló un flujo de aprobación de documentos en el que diferentes responsables procesan el documento dependiendo de su estado.

### Implementación

El patrón **Chain of Responsibility** permite encadenar diferentes responsables del proceso:

`AuthorHandler → LeaderHandler → LegalHandler`

Cada handler decide si puede procesar el documento o si debe continuar con el siguiente.

El patrón **State** permite representar los diferentes estados del documento:

`DraftState → InReviewState → ApprovedState`

También se contempla el estado `RejectedState`.

De esta forma, el comportamiento del documento depende de su estado actual.

---

## Ejercicio 8 — Sistema de Pedidos en Restaurante

### Patrones utilizados
- Builder
- Observer

### Descripción
Se desarrolló un sistema para construir pedidos personalizados de restaurante y notificar a los diferentes servicios cuando un pedido es confirmado.

### Implementación

El patrón **Builder** permite construir un pedido paso a paso utilizando `OrderBuilder`, agregando características como tamaño, tipo de carne, toppings y acompañamientos.

El patrón **Observer** permite notificar automáticamente a los diferentes servicios cuando el pedido es confirmado.

Los observadores implementados fueron:

- `KitchenService`
- `BillingService`
- `DeliveryService`

La interacción principal es:

`Order → confirm() → KitchenService / BillingService / DeliveryService`

---

## Ejercicio 9 — Sistema de Autenticación Empresarial

### Patrones utilizados
- Strategy
- Chain of Responsibility

### Descripción
Se desarrolló un sistema de autenticación empresarial que permite seleccionar diferentes mecanismos de autenticación y posteriormente ejecutar una cadena de validaciones.

### Implementación

El patrón **Strategy** permite seleccionar el mecanismo de autenticación mediante `AuthStrategy`.

Se implementaron diferentes estrategias:

- `PasswordStrategy`
- `GoogleStrategy`
- `BiometricStrategy`

El patrón **Chain of Responsibility** permite ejecutar las validaciones posteriores mediante:

`CredentialValidator → PermissionValidator → LocationValidator → TimeValidator`

De esta manera, el sistema puede cambiar el mecanismo de autenticación sin modificar el proceso general de validación.

---

## Ejercicio 10 — Aplicación de Edición de Imágenes

### Patrones utilizados
- Decorator
- Command

### Descripción
Se desarrolló una aplicación que permite aplicar filtros de manera acumulativa sobre una imagen y deshacer las operaciones realizadas.

### Implementación

El patrón **Decorator** permite agregar filtros a una imagen sin modificar la clase original.

Se implementaron:

- `GrayscaleDecorator`
- `SepiaDecorator`
- `BrightnessDecorator`

Los filtros pueden combinarse de forma acumulativa:

`BaseImage → GrayscaleDecorator → SepiaDecorator → BrightnessDecorator`

El patrón **Command** encapsula cada operación de aplicación de filtros mediante `ApplyFilterCommand`.

Cada comando permite:

- `execute()` para aplicar el filtro.
- `undo()` para deshacer la operación.

---

## Patrones de diseño utilizados

| Patrón | Ejercicios | Propósito |
|---|---|---|
| Strategy | 6, 9 | Permitir seleccionar o cambiar algoritmos o comportamientos |
| Observer | 6, 8 | Notificar automáticamente a diferentes componentes |
| Chain of Responsibility | 7, 9 | Procesar solicitudes mediante una cadena de responsables |
| State | 7 | Cambiar el comportamiento según el estado de un objeto |
| Builder | 8 | Construir objetos complejos paso a paso |
| Adapter | 5 | Adaptar una interfaz existente a otra compatible |
| Facade | 5 | Simplificar el acceso a un sistema complejo |
| Decorator | 10 | Agregar funcionalidades de manera acumulativa |
| Command | 10 | Encapsular operaciones y permitir ejecutarlas o deshacerlas |

---

## Conclusiones

Durante el Taller #4 se aplicaron diferentes patrones de diseño para resolver problemas de software con estructuras más organizadas y flexibles.

Los ejercicios permitieron observar cómo diferentes patrones pueden combinarse para separar responsabilidades, reducir el acoplamiento y facilitar la extensión de los sistemas.

Además, se comprobó mediante la ejecución de los ejercicios que las implementaciones desarrolladas cumplen con el comportamiento esperado.
