package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import static org.assertj.core.api.Assertions.assertThat;


public class ListReasonRejectIT extends BaseIntegrationTest{
    
    @Test
    public void testListReasonReject() {
        HttpHeaders headers = getAuthorizedHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{ \"page\": 1, \"perPage\": 100 }";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange("http://server/ticket/reason_reject/fetch",
        HttpMethod.POST,request,String.class);
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response List reason: " + response.getBody());
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }}
