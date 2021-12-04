package manytomany.customeraccounts;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class CustomerAccountDao {

    public void addNewCustomer(Customer customer){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        session.close();
    }

    public Customer getCustomer(long phoneNumber){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select c from Customer c where c.phoneNo = :phoneNo");
        query.setLong("phoneNo",phoneNumber);
        List<Customer> customerList = query.getResultList();
//        int timetaken = tx.getTimeout();
//        System.out.println("Time taken to getCustomer : "+timetaken);
        tx.commit();
        session.close();
        return customerList.get(0);
    }

    public Set<Long> getAccountNumbers(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query query = session.createQuery("select acc.accountNo from Account acc");
        List<Long> list = query.getResultList();
        session.close();
        return ConfigParser.populateHashSet(list);
    }

    public Customer addExistingCustomerWithNewAccount(int customerId, Account account){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        return null;
    }

    /*
    Joint account
     */
    public Customer addExistingCustomerWithExistingAccount(int customerId, long accountId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        return null;
    }

    public Customer deleteAccountFromCustomer(int customerId, long accountId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        return null;
    }

    public Customer deleteCustomer(int customerId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        return null;
    }

}
