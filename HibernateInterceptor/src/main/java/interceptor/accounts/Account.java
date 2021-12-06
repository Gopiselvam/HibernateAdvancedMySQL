package interceptor.accounts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT_INTERCEPTOR")
public class Account {

	@Id
	private int accountNumber;
	private LocalDate accountOpeningDate;
	private double balance;

	public Account() {

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDate accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountNumber=" + accountNumber +
				", accountOpeningDate=" + accountOpeningDate +
				", balance=" + balance +
				'}';
	}
}
