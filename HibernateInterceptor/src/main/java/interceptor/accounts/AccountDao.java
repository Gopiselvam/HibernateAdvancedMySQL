package interceptor.accounts;

import interceptor.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDao {

    public void addAccount(Account account){
        Session session = HibernateUtils.getSessionFactory().
                withOptions().interceptor(new LoggerInterceptor())
                .openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(account);

        tx.commit();
        session.close();
    }

    public void addBalance(int accNum, double amount){
        Session session = HibernateUtils.getSessionFactory().
                withOptions().interceptor(new LoggerInterceptor())
                .openSession();
        Transaction tx = session.beginTransaction();

        Account account = session.get(Account.class, accNum);
        account.setBalance(account.getBalance()+amount);

        session.saveOrUpdate(account);

        tx.commit();
        session.close();
    }
}
