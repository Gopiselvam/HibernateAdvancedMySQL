package manytomany.customeraccounts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Account implements Serializable {
    @Id
    private Long accountNo;
    private String accountType;
    private LocalDate openingDate;
    private Double balance;
    private String accountStatus;
//    @ManyToMany(mappedBy = "accounts")
//    private List<Customer> customers;
//
//    public List<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }

    public Account() {
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountType='" + accountType + '\'' +
                ", openingDate=" + openingDate +
                ", balance=" + balance +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
