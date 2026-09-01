package dosw.semana_4.patrones;

public class HomePageComponent implements PreferenceObserver {

    private RecommendationAlgorithm algorithm;

    public HomePageComponent(RecommendationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(RecommendationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void onPreferenceChanged(User user) {
        System.out.println(
                "HomePage actualizada: " +
                        algorithm.recommend(user)
        );
    }
}