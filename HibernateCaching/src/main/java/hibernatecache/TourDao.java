package hibernatecache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TourDao {


    public void getTourDetails() {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.get(TourEntity.class, "INDSING5C");
            System.out.println("First Read");
            session.get(TourEntity.class, "INDSING5C");
            System.out.println("Second Read");
            HibernateUtils.getSessionFactory().getCache().evictAllRegions();
            Session session2 = HibernateUtils.getSessionFactory().openSession();
            session2.get(TourEntity.class, "INDSING5C");
            System.out.println("Third Read");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
//            sessionFactory.close();
        }
    }
}
