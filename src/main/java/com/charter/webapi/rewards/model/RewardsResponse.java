package com.charter.webapi.rewards.model;

import com.charter.webapi.rewards.error.ErrorResponse;

public class RewardsResponse {
    private String customerId;
    private String customerName;
    private String totalPoints;
    private MonthlyPoints monthlyPoints;
    private ErrorResponse errors;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public MonthlyPoints getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(MonthlyPoints monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public ErrorResponse getErrors() {
        return errors;
    }

    public void setErrors(ErrorResponse errors) {
        this.errors = errors;
    }
}
