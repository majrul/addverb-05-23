package com.example;

import com.example.dto.RegisterStatus;
import com.example.dto.Status;
import com.example.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegisterApi() {
        Customer customer = new Customer();
        customer.setName("Raj");
        customer.setEmail("raj@gmail.com");
        customer.setCity("Pune");

        HttpHeaders headers = new HttpHeaders();
        headers.add("access-token", "asasa9232323sdsd");
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer, headers);

        //String response = restTemplate.postForObject("/register", requestEntity, String.class);
        //System.out.println(response);
        RegisterStatus status = restTemplate.postForObject("/register", requestEntity, RegisterStatus.class);
        System.out.println(status.getStatusCode() + " , " + status.getMessageIfAny());
    }
}
