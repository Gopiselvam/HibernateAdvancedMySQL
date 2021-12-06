package events.accounts;

import events.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDao {

    public void addAccount(Account account){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(account);

        tx.commit();
        session.close();
    }
}
