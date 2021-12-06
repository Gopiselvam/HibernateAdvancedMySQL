package interceptor.accounts;


import interceptor.HibernateUtils;

public class MainClassEvents {

    private static AccountService service = new AccountService();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
        service.accountService();
    }
}
