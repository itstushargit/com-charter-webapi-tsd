package com.charter.webapi.rewards.model;

import java.util.List;

public class AllTransactions {
    private List<CustomerTransaction> customerTransactions;

    public List<CustomerTransaction> getCustomerTransactions() {
        return customerTransactions;
    }

    public void setCustomerTransactions(List<CustomerTransaction> customerTransactions) {
        this.customerTransactions = customerTransactions;
    }
}
