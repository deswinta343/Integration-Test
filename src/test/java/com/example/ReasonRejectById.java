package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MyApplication.class)
public class ReasonRejectById {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetReasonReject() {
        String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBZG1pblRlc3QxIiwiZXhwIjoxNzI0ODcyMDM3LCJpYXQiOjE3MjQ4MzYwMzd9.foZUdVyFrPzenkAXulNky4_Dw_iQlyuyBH0rUv0jSdk";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token); 
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://server/ticket/reason_reject?id=1",
                HttpMethod.GET,
                request,
                String.class
        );

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Reason reject by id: " + response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
