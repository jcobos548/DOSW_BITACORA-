package dosw.semana_4.patrones;

public class SuggestedListComponent implements PreferenceObserver {

    private RecommendationAlgorithm algorithm;

    public SuggestedListComponent(RecommendationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(RecommendationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void onPreferenceChanged(User user) {
        System.out.println(
                "Lista de sugeridos actualizada: " +
                        algorithm.recommend(user)
        );
    }
}
