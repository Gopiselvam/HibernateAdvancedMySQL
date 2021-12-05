package envers.customers;

import envers.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDao {

    public void addCustomer(Customer customer){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
        session.close();
    }

    public void updateCustomerEmail(int customerId, String newEmail){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, customerId);
        customer.setEmailId(newEmail);
        session.saveOrUpdate(customer);

        tx.commit();
        session.close();
    }

}
