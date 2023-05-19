package com.example;

import com.example.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

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

        String response = restTemplate.postForObject("/register", customer, String.class);
        System.out.println(response);
    }
}
