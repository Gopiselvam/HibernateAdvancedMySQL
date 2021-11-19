package com.customerloan.embeddedid;

import com.ConfigParser;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class CustomerLoanService {

    private static String customerLoanFilePath = "src/main/resources/customerLoan.txt";
    private CustomerLoanDao customerLoanDao = new CustomerLoanDao();

    public void customerLoanService() {
        System.out.println("Welcome to CUSTOMER LOAN");
        int opt = 0;
        Scanner sc = new Scanner(System.in);
        Integer customerId = 0;
        String loanId = "";

        loop1:
        while (true) {
            System.out.printf("%n%n%8s%s%n", "press 1:", "To populate the Customer Loan table");
            System.out.printf("%8s%s%n", " 2:", "To find the CUstomer loan details");
            System.out.printf("%8s%s%n", " 0:", "To Exit");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    addCustomerLoanFromLogs();
                    break;
                case 2:
                    // 1003 L503
                    System.out.println("Enter the Customer Id: ");
                    customerId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Loan Id: ");
                    loanId = sc.nextLine();
                    retriveCustomerLoanDetails(customerId, loanId);
                    break;
                default:
                    break loop1;

            }
        }

    }

    private void retriveCustomerLoanDetails(Integer customerId, String loanId) {

        CustomerLoan obj = customerLoanDao.getCustomerLoan(customerId, loanId.trim());
        if(null == obj){
            System.err.println("No objects found");
            return;
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            System.out.printf("%20s|", field.getName());
        }
        System.out.println();

        System.out.printf("%20d|%20s|%20.2f|%20.2f|%20.2f%n", obj.getCustomerLoanPK().getCustomerId(),
                obj.getCustomerLoanPK().getLoanId(),
                obj.getEligibleAmount(),
                obj.getAvailedAmount(),
                obj.getTenureInYears());


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
