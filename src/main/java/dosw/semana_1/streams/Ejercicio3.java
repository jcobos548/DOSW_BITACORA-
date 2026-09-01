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