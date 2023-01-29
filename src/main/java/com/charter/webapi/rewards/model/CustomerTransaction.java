package com.charter.webapi.rewards.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerTransaction {
    private String customerId;
    private String customerName;
    private List<Transaction> transactions;
}
