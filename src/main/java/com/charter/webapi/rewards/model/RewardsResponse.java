package com.charter.webapi.rewards.model;

import com.charter.webapi.rewards.error.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardsResponse {
    private String customerId;
    private String customerName;
    private String totalPoints;
    private MonthlyPoints monthlyPoints;
    private ErrorResponse errors;
}
