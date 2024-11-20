// package com.example;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.MediaType;

// import java.util.Collections;

// import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MyApplication.class)
// public class RegisterIntegrationTest {

//     @Autowired
//     private TestRestTemplate restTemplate;

//     @Test
//     public void testRegister() {
//         // Membuat header untuk permintaan
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.setAccept(Collections.singletonList(MediaType.ALL));

//         // Membuat body untuk permintaan
//         String requestBody = "{ \"username\": \"Integrate5\", \"email\": \"testt@gmail.com\", \"password\": \"AdminTest123*\", \"jabatan\": \"MANAGER\", \"roles\": [\"ADMIN\"], \"divisionId\": 2 }";

//         // Membuat entitas HTTP dengan header dan body
//         HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

//         // Mengirimkan permintaan POST ke endpoint register
//         ResponseEntity<String> response = restTemplate.exchange(
//                 "http://server/ticket/user/public/register",
//                 HttpMethod.POST,
//                 request,
//                 String.class);

//         // Menampilkan respons dari server
//         System.out.println("Response Status Code: " + response.getStatusCode());
//         System.out.println("Response Body: " + response.getBody());

//         // Memeriksa bahwa status respons adalah 200 OK (atau 201 Created sesuai yang diharapkan)
//        //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

//        //assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

//         // Memeriksa bahwa respons mengandung pesan yang relevan
//         assertThat(response.getBody()).contains("SUCCESS");
//     }
// }
