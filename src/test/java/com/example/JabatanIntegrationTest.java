package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class JabatanIntegrationTest extends BaseIntegrationTest {
    
    @Test
    public void testGetJabatan() {
        HttpHeaders headers = getAuthorizedHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://server/ticket/user/jabatan",
        HttpMethod.GET,request,String.class);

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response List Jabatan: " + response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

