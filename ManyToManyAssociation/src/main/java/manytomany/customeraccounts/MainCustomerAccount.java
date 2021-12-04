package manytomany.customeraccounts;

public class MainCustomerAccount {

    private static final CustomerAccountService service = new CustomerAccountService();
    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
        service.invokeCustomerAccountServices();
    }
}
