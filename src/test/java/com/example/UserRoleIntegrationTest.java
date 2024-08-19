package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
public class UserRoleIntegrationTest extends BaseIntegrationTest {

    @Test
    public void testGetUserRoles() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate.exchange("http://152.42.188.210:8080/ticket/user/roles",
                HttpMethod.GET,request,String.class);
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response User role: " + response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("data");
    }}
