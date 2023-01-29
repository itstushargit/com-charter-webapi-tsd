package com.charter.webapi.rewards.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllTransactions {
    private List<CustomerTransaction> customerTransactions;
}
