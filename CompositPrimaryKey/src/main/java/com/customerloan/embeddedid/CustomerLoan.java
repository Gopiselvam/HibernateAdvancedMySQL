package com.customerloan.embeddedid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CustomerLoan {
    @EmbeddedId
    private CustomerLoanPK customerLoanPK;
    private Double eligibleAmount;
    private Double availedAmount;
    private Float tenureInYears;

    public CustomerLoan() {

    }

    public CustomerLoanPK getCustomerLoanPK() {
        return customerLoanPK;
    }

    public void setCustomerLoanPK(CustomerLoanPK customerLoanPK) {
        this.customerLoanPK = customerLoanPK;
    }

    public Double getEligibleAmount() {
        return eligibleAmount;
    }

    public void setEligibleAmount(Double eligibleAmount) {
        this.eligibleAmount = eligibleAmount;
    }

    public Double getAvailedAmount() {
        return availedAmount;
    }

    public void setAvailedAmount(Double availedAmount) {
        this.availedAmount = availedAmount;
    }

    public Float getTenureInYears() {
        return tenureInYears;
    }

    public void setTenureInYears(Float tenureInYears) {
        this.tenureInYears = tenureInYears;
    }
}
