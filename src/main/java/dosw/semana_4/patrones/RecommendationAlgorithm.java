package dosw.semana_4.patrones;

import java.util.List;

public interface RecommendationAlgorithm {
    List<Content> recommend(User user);
}