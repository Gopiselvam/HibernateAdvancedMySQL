package com.customerloan.embeddedid;

import com.ConfigParser;

import java.util.List;

public class CustomerLoanService {

    private static String customerLoanFilePath = "src/main/resources/customerLoan.txt";
    private CustomerLoanDao customerLoanDao = new CustomerLoanDao();

    public void customerLoanService() {
        addCustomerLoanFromLogs();
    }

    private void addCustomerLoanFromLogs() {
        List<CustomerLoan> list = ConfigParser.getListFromInput(customerLoanFilePath);
        try {
            customerLoanDao.addCustomerLoan(list);
        } catch (Exception ex) {
            System.err.println("Customer Loan data already populated");
            ex.printStackTrace();
        }

    }


}
