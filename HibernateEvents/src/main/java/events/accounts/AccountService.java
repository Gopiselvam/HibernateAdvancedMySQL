package events.accounts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountService {

    private AccountDao dao = new AccountDao();
    private  Scanner sc = new Scanner(System.in);
    public void accountService(){
        addAccount();
    }

    private void addAccount() {
        System.out.println("Enter account number");
        int accNum = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the account opening date");
        String accOpenDate = sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate accountOpeningDate = LocalDate.parse(accOpenDate, dtf);

        System.out.println("Enter account balance");
        Double accBal = sc.nextDouble();
        sc.nextLine();

        Account account = new Account();
        account.setAccountNumber(accNum);
        account.setAccountOpeningDate(accountOpeningDate);
        account.setBalance(accBal);

        dao.addAccount(account);


    }
}
