package com.charter.webapi.rewards.controller;

import com.charter.webapi.rewards.config.ConfigProperties;
import com.charter.webapi.rewards.model.RewardsResponse;
import com.charter.webapi.rewards.service.CharterRewordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rewards")
@Slf4j
public class CharterRewordsController {

    @Autowired
    CharterRewordsService charterRewordsService;

    @GetMapping(value = "/{customerId}/availablePoints", produces = "application/json")
    public ResponseEntity<RewardsResponse> getRewordPoints(@PathVariable String customerId){
        RewardsResponse rewardsResponse = charterRewordsService.getRewords(customerId);
        log.info("Returning reword points.");
        return ResponseEntity.ok(rewardsResponse);
    }
}
