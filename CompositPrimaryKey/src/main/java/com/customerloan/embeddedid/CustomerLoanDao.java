package com.customerloan.embeddedid;

import com.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerLoanDao {

    public void addCustomerLoan(List<CustomerLoan> list) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        list.forEach(session::save);

        tx.commit();
        session.close();

    }

    public void getCustomerLoan(Integer customerId, String loanId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.close();

    }
}
