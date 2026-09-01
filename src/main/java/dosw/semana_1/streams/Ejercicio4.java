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