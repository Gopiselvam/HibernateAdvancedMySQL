package envers.customers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CustomerService {

    private Scanner sc = new Scanner(System.in);

    private CustomerDao dao = new CustomerDao();

    public void customerServices(){
//        addCustomerService();
        updateCustomerService();
    }

    /*
    TO update email id
     */
    private void updateCustomerService() {
        System.out.println("Enter the customer id to be modified");
        int custId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new Email id");
        String custEmail = sc.nextLine();

        dao.updateCustomerEmail(custId, custEmail);

    }

    private void addCustomerService() {
        System.out.println("Enter customer Id");
        int custId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter customer name");
        String custName = sc.nextLine();
        System.out.println("Enter customer DOB in dd-MM-yyyy formate. eg: 28-01-1994");
        String custDOB = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate convertedDob = LocalDate.parse(custDOB, formatter);

        System.out.println("Enter customer email id");
        String custEmail = sc.nextLine();

        Customer customer = new Customer();
        customer.setCustomerId(custId);
        customer.setName(custName);
        customer.setDob(convertedDob);
        customer.setEmailId(custEmail);

        dao.addCustomer(customer);

        System.out.println("Customer Data added");

    }
}
