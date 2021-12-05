package envers;

import envers.customers.CustomerService;

public class MainClassEnvers {

    private static CustomerService service = new CustomerService();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
        service.customerServices();
    }
}
