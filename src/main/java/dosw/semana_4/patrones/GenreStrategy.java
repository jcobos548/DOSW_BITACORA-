package dosw.semana_4.patrones;

import java.util.List;

public class GenreStrategy implements RecommendationAlgorithm {

    private final List<Content> contents;

    public GenreStrategy(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public List<Content> recommend(User user) {
        return contents.stream()
                .filter(content ->
                        content.getGenre().equalsIgnoreCase(user.getPreference()))
                .toList();
    }
}
