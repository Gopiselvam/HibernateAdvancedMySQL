package events.accounts;

import events.HibernateUtils;

public class MainClassEvents {

    private static AccountService service = new AccountService();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
        service.accountService();
    }
}
