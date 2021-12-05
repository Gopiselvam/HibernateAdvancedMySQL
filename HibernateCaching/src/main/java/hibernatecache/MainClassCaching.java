package hibernatecache;

public class MainClassCaching {
    private static TourDao dao = new TourDao();
    public static void main(String[] args) {

        HibernateUtils.createSessionFactory();
        dao.getTourDetails();
    }
}
