package dosw.semana_4.patrones;

import java.util.List;

public class Ejercicio6 {

    public static void main(String[] args) {

        List<Content> contents = List.of(
                new Content("Interestelar", "Ciencia ficción"),
                new Content("Matrix", "Ciencia ficción"),
                new Content("Titanic", "Romance"),
                new Content("El Padrino", "Drama")
        );

        User user = new User(
                "Carlos",
                "Ciencia ficción"
        );

        RecommendationAlgorithm genreStrategy =
                new GenreStrategy(contents);

        HomePageComponent homePage =
                new HomePageComponent(genreStrategy);

        SuggestedListComponent suggestedList =
                new SuggestedListComponent(genreStrategy);

        UserProfile profile = new UserProfile(user);

        profile.addObserver(homePage);
        profile.addObserver(suggestedList);

        profile.changePreference("Ciencia ficción");

        profile.changePreference("Romance");
    }
}