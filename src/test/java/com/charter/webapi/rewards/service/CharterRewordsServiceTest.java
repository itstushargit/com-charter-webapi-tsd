package com.charter.webapi.rewards.service;

import com.charter.webapi.rewards.config.ConfigProperties;
import com.charter.webapi.rewards.model.AllTransactions;
import com.charter.webapi.rewards.model.RewardsResponse;
import com.charter.webapi.rewards.util.RewardsUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application.yml")
class CharterRewordsServiceTest {

    CharterRewordsService charterRewordsService;

    @Autowired
    ConfigProperties configProperties;

    @Mock
    RewardsUtil rewardsUtil;

    String transactionString = "{\"customerTransactions\":[{\n" +
            " \"customerId\": \"1001\",\n" +
            " \"customerName\": \"John\",\n" +
            " \"transactions\": [{\n" +
            "                    \"month\": \"monthOne\",\n" +
            "                    \"transactionAmount\": \"110\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"month\": \"monthOne\",\n" +
            "                    \"transactionAmount\": \"40\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"month\": \"monthTwo\",\n" +
            "                    \"transactionAmount\": \"10\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"month\": \"monthThree\",\n" +
            "                    \"transactionAmount\": \"90\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"month\": \"monthThree\",\n" +
            "                    \"transactionAmount\": \"50\"\n" +
            "                  }\n" +
            " ]\n" +
            "}, {\n" +
            "  \"customerId\": \"1002\",\n" +
            "  \"customerName\": \"David\",\n" +
            "  \"transactions\": [{\n" +
            "                     \"month\": \"monthOne\",\n" +
            "                     \"transactionAmount\": \"190\"\n" +
            "                   },\n" +
            "                   {\n" +
            "                     \"month\": \"monthOne\",\n" +
            "                     \"transactionAmount\": \"40\"\n" +
            "                   },\n" +
            "                   {\n" +
            "                     \"month\": \"monthTwo\",\n" +
            "                     \"transactionAmount\": \"130\"\n" +
            "                   }\n" +
            "  ]\n" +
            "}, {\n" +
            "  \"customerId\": \"1003\",\n" +
            "  \"customerName\": \"Ramesh\",\n" +
            "  \"transactions\": [{\n" +
            "                     \"month\": \"monthOne\",\n" +
            "                     \"transactionAmount\": \"120\"\n" +
            "                   },\n" +
            "                   {\n" +
            "                     \"month\": \"monthTwo\",\n" +
            "                     \"transactionAmount\": \"110\"\n" +
            "                   },\n" +
            "                   {\n" +
            "                     \"month\": \"monthThree\",\n" +
            "                     \"transactionAmount\": \"60\"\n" +
            "                   }\n" +
            "  ]\n" +
            "}]}";

    @BeforeEach
    void setUp() {
        rewardsUtil = new RewardsUtil();
        ReflectionTestUtils.setField(configProperties, "transactionDetail", transactionString);
        ReflectionTestUtils.setField(configProperties,"allTransactions", createAllTransactions());
        charterRewordsService = new CharterRewordsService(configProperties, rewardsUtil);
    }

    @Test
    void getRewords() {
        RewardsResponse rewardsResponse = charterRewordsService.getRewords("1001");
        assertEquals(rewardsResponse.getCustomerId(), "1001");
        assertEquals(rewardsResponse.getTotalPoints(), "110");
    }

    public AllTransactions createAllTransactions(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(transactionString, AllTransactions.class);
        }catch(Exception exp){
            System.out.println("ERROR-- "+exp);
        }
        return null;
    }
}