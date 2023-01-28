package com.charter.webapi.rewards.error;

import com.charter.webapi.rewards.model.RewardsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RewardsAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RewardsResponse handleNoCustomerException(NoSuchElementException ex){
        RewardsResponse rewardsResponse = new RewardsResponse();
        rewardsResponse.setErrors(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Customer not found!!"));
        return rewardsResponse;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody RewardsResponse handleException(Exception ex){
        RewardsResponse rewardsResponse = new RewardsResponse();
        rewardsResponse.setErrors(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong !! Please try again!!"));
        return rewardsResponse;
    }
}
