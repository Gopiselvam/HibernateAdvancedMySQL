package criteriaAPI;

import criteriaAPI.movieEntity.MovieService;

public class MainCriteriaAPI {

    private static MovieService service = new MovieService();
    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
        service.movieServices();
    }
}
