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

    public CustomerLoan getCustomerLoan(Integer customerId, String loanId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CustomerLoanPK customerLoanPK = new CustomerLoanPK();
        customerLoanPK.setCustomerId(customerId);
        customerLoanPK.setLoanId(loanId);

        CustomerLoan loan = session.get(CustomerLoan.class, customerLoanPK);

        session.close();

        return loan;

    }
}
