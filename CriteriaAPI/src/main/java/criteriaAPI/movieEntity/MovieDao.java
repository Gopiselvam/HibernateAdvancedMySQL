package criteriaAPI.movieEntity;

import criteriaAPI.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class MovieDao {
    public void addMovies(List<MovieEntity> movieList) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        for(MovieEntity movie : movieList){
            session.save(movie);
        }
        tx.commit();
        session.close();
    }


    public List<MovieEntity> getAllMovies(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(MovieEntity.class);
        List<MovieEntity> list = criteria.list();
        tx.commit();
        session.close();
        return list;
    }

    public List<MovieEntity> getMoviesInBetweenWithPrefix(Integer startYear, Integer endYear, String prefix) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(MovieEntity.class);
        Criterion criterion1 = Restrictions.between("releasedIn", startYear, endYear);
        Criterion criterion2 = Restrictions.ilike("movieId", prefix+"%");
        LogicalExpression andExp = Restrictions.and(criterion1, criterion2);
        criteria.add(andExp);
        List<MovieEntity> list = criteria.list();
        tx.commit();
        session.close();
        return list;

    }
}
