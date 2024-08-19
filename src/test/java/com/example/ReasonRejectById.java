package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class ReasonRejectById extends BaseIntegrationTest {
    
    @Test
    public void testGetReasonReject() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://152.42.188.210:8080/ticket/reason_reject?id=1",
        HttpMethod.GET,request,String.class);
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Reason reject by id: " + response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("id");
    }}


