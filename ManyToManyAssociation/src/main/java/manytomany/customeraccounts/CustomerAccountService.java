package manytomany.customeraccounts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CustomerAccountService {

    Scanner sc = new Scanner(System.in);
    private CustomerAccountDao dao = new CustomerAccountDao();

    public void invokeCustomerAccountServices() {

//        addNewCustomerService();
        getCustomerWithAccounts();

    }

    private void getCustomerWithAccounts() {
        System.out.println("Enter the customer phone number ");
        long phoneNumber = sc.nextLong();
        sc.nextLine();
        Customer customer = dao.getCustomer(phoneNumber);
        if(null != customer){
            System.out.println(customer);
        }else{
            System.err.println("Customer not found");
        }
    }

    /*
        System.out.println("Enter the Customer Id");
        System.out.println("Enter the Customer Name");
        System.out.println("Enter the DOB in dd-MM-yyyy");
        System.out.println("Enter the address");
        System.out.println("Enter the phone number");

        System.out.println("Enter the number of account required");

        System.out.println("Enter the Account number");
        System.out.println("Enter the account type");
        System.out.println("Enter the initial balance");
     */
    private void addNewCustomerService() {
//        System.out.println("Enter the Customer Id");
//        int customerId = sc.nextInt();
//        sc.nextLine();
        System.out.println("Enter the Customer Name");
        String customerName = sc.nextLine();
        System.out.println("Enter the DOB in dd-MM-yyyy");
        String customerDOB = sc.nextLine();
        System.out.println("Enter the address");
        String address = sc.nextLine();
        System.out.println("Enter the phone number");
        long phoneNumber = sc.nextLong();

        Customer customer = new Customer();
//        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setDateOfBirth(ConfigParser.getLocalData(customerDOB));
        customer.setAddress(address);
        customer.setPhoneNo(phoneNumber);

        System.out.println("Enter the number of account required");
        int noOfAccounts = sc.nextInt();
        sc.nextLine();
        Account account = null;

        // getting already generated account numbers
        Set<Long> accountSet = dao.getAccountNumbers();

        List<Account> customerAccountsList = new ArrayList<>();
        for (int i = 0; i < noOfAccounts; i++) {

            System.out.println("Enter the account type for account : " + (i+1));
            String accountType = sc.nextLine();
            System.out.println("Enter the initial balance for account : " + (i+1));
            Double balance = sc.nextDouble();
            sc.nextLine();
            account = new Account();
            account.setAccountType(accountType);
            account.setBalance(balance);

            long accountNumber;
            do {
                accountNumber = ConfigParser.generateAccountNumberMathAPI();
            } while (accountSet.contains(accountNumber));

            accountSet.add(accountNumber);

            account.setAccountNo(accountNumber);
            account.setOpeningDate(LocalDate.now());
            account.setAccountStatus("Active");

            customerAccountsList.add(account);
        }

        customer.setAccounts(customerAccountsList);

        dao.addNewCustomer(customer);


    }
}
