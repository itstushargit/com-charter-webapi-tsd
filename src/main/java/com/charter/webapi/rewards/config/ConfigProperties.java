package com.charter.webapi.rewards.config;


import com.charter.webapi.rewards.model.AllTransactions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "data")
@Configuration
public class ConfigProperties {
    String transactionDetail;
    AllTransactions allTransactions;

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail){
        this.transactionDetail = transactionDetail;
        try{
            ObjectMapper mapper = new ObjectMapper();
            this.allTransactions = mapper.readValue(transactionDetail, AllTransactions.class);
        }catch(Exception exp){
            System.out.println("ERROR-- "+exp);
        }
    }

    public AllTransactions getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(AllTransactions allTransactions) {
        this.allTransactions = allTransactions;
    }
}
