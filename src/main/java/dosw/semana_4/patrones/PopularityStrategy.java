package dosw.semana_4.patrones;

import java.util.List;

public class PopularityStrategy implements RecommendationAlgorithm {

    private final List<Content> contents;

    public PopularityStrategy(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public List<Content> recommend(User user) {
        return contents.stream()
                .limit(2)
                .toList();
    }
}
