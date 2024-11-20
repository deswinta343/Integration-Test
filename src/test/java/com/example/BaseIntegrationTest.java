package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MyApplication.class)
public abstract class BaseIntegrationTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    protected static String token;

    @BeforeAll
    public static void login(@Autowired TestRestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        String requestBody = "{ \"username\": \"AdminTest1\", \"password\": \"AdminTest1**\" }";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://server/ticket/user/public/login",
                HttpMethod.POST, request, String.class
        );

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Login: " + response.getBody());

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            token = response.getBody().substring(
                    response.getBody().indexOf("token\":\"") + 8, 
                    response.getBody().indexOf("\",\"responseDTO")
            );
        }
    }

    protected HttpHeaders getAuthorizedHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setBearerAuth(token); // Menambahkan token ke dalam header Authorization
        return headers;
    }
}
