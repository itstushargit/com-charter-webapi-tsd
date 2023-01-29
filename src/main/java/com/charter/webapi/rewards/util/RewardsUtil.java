package com.charter.webapi.rewards.util;

import com.charter.webapi.rewards.model.CustomerTransaction;
import com.charter.webapi.rewards.model.MonthlyPoints;
import com.charter.webapi.rewards.model.RewardsResponse;
import com.charter.webapi.rewards.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class RewardsUtil {

    public RewardsResponse canculateRewords(CustomerTransaction customerTransaction){
        RewardsResponse rewardsResponse = new RewardsResponse();
        MonthlyPoints monthlyPoints = setAllMonthsPoints(customerTransaction.getTransactions());
        rewardsResponse.setCustomerId(customerTransaction.getCustomerId());
        rewardsResponse.setCustomerName(customerTransaction.getCustomerName());
        rewardsResponse.setMonthlyPoints(monthlyPoints);
        rewardsResponse.setTotalPoints(calculateTotalPoints(monthlyPoints));
        log.info("Points calculated for customer rewords.");
        return rewardsResponse;
    }

    public MonthlyPoints setAllMonthsPoints(List<Transaction> allTransactions){
        Map<String, Integer> pointMap = new ConcurrentHashMap<>();
        MonthlyPoints monthlyPoints = new MonthlyPoints();
        allTransactions.stream().forEach(i -> {
            if(i.getMonth().equalsIgnoreCase("monthOne"))
                pointMap.put("monthOne", (pointMap.get("monthOne") != null ? pointMap.get("monthOne") : 0 ) + calculatePoints(Integer.parseInt(i.getTransactionAmount())));
            else if(i.getMonth().equalsIgnoreCase("monthTwo"))
                pointMap.put("monthTwo", (pointMap.get("monthTwo") != null ? pointMap.get("monthTwo") : 0 ) + calculatePoints(Integer.parseInt(i.getTransactionAmount())));
            else
                pointMap.put("monthThree", (pointMap.get("monthThree") != null ? pointMap.get("monthThree") : 0 ) + calculatePoints(Integer.parseInt(i.getTransactionAmount())));
        });

        monthlyPoints.setMonthOne(pointMap.get("monthOne") != null ? pointMap.get("monthOne") : 0 );
        monthlyPoints.setMonthTwo(pointMap.get("monthTwo") != null ? pointMap.get("monthTwo") : 0 );
        monthlyPoints.setMonthThree(pointMap.get("monthThree") != null ? pointMap.get("monthThree") : 0 );
        return monthlyPoints;
    }

    public String calculateTotalPoints(MonthlyPoints monthlyPoints){
        return Integer.valueOf(monthlyPoints.getMonthOne()+monthlyPoints.getMonthTwo()+monthlyPoints.getMonthThree()).toString();
    }

    public Integer calculatePoints(Integer transAmount){
        int transactionAmount = (transAmount != null ? transAmount : Integer.valueOf(0));
        int points = 0;
        if(transactionAmount > 50 && transactionAmount <=100)
            points = transactionAmount - 50;
        else if(transactionAmount > 100)
            points = ((transactionAmount - 100)*2) + 50;
        return Integer.valueOf(points);
    }
}
