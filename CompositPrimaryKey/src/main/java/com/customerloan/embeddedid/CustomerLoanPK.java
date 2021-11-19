package com.customerloan.embeddedid;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerLoanPK implements Serializable {
    private Integer customerId;
    private String loanId;

    public CustomerLoanPK() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
}
