package com.charter.webapi.rewards.service;

import com.charter.webapi.rewards.config.ConfigProperties;
import com.charter.webapi.rewards.model.CustomerTransaction;
import com.charter.webapi.rewards.model.RewardsResponse;
import com.charter.webapi.rewards.util.RewardsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CharterRewordsService {

    ConfigProperties configProperties;
    RewardsUtil rewardsUtil;

    @Autowired
    public CharterRewordsService(ConfigProperties configProperties, RewardsUtil rewardsUtil){
        this.configProperties = configProperties;
        this.rewardsUtil = rewardsUtil;
    }

    public RewardsResponse getRewords(String customerId){
        CustomerTransaction customerTransaction = getTransaction(customerId);
        log.info("Got customer specific transactions.");
        return rewardsUtil.canculateRewords(customerTransaction);
    }

    public CustomerTransaction getTransaction(String customerId){
        List<CustomerTransaction> customerTransactions = configProperties.getAllTransactions().getCustomerTransactions();
        return customerTransactions.stream().filter(c -> c.getCustomerId().equalsIgnoreCase(customerId)).findFirst().get();
    }

}
