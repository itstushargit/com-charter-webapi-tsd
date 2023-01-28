package com.charter.webapi.rewards.util;

import com.charter.webapi.rewards.model.CustomerTransaction;
import com.charter.webapi.rewards.model.RewardsResponse;
import com.charter.webapi.rewards.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RewardsUtilTest {

    @InjectMocks
    RewardsUtil rewardsUtil;

    @BeforeEach
    void setUp() {
        rewardsUtil = new RewardsUtil();
    }

    @Test
    void canculateRewords() {
        CustomerTransaction customerTransaction = populateTransactions();
        RewardsResponse rewardsResponse = rewardsUtil.canculateRewords(customerTransaction);
        assertEquals(rewardsResponse.getCustomerId(), customerTransaction.getCustomerId());
        assertEquals(rewardsResponse.getTotalPoints(), "160");
    }


    public CustomerTransaction populateTransactions(){
        CustomerTransaction customerTransaction = new CustomerTransaction();
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        transaction1.setMonth("one");
        transaction1.setTransactionAmount("120");
        transactions.add(transaction1);
        Transaction transaction2 = new Transaction();
        transaction2.setMonth("two");
        transaction2.setTransactionAmount("70");
        transactions.add(transaction2);
        Transaction transaction3 = new Transaction();
        transaction3.setMonth("three");
        transaction3.setTransactionAmount("100");
        transactions.add(transaction3);
        customerTransaction.setCustomerId("1009");
        customerTransaction.setCustomerName("2008");
        customerTransaction.setTransactions(transactions);
        return customerTransaction;
    }
}