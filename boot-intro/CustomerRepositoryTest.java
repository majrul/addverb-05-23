package com.example;


import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(true)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setName("John");
        customer.setEmail("john@gmail.com");
        customer.setCity("Pune");
        customerRepository.save(customer);
    }

    @Test
    public void testFetchCustomersByEmail() {
        List<Customer> list = customerRepository.findByEmailOf("gmail");
        Assertions.assertTrue(list.size() > 0);
        for (Customer customer : list)
            System.out.println(customer); //NO NO NO
    }

    @Test
    public void addFewCustomers() {
        for(int i=0; i< 25; i++) {
            Customer customer = new Customer();
            customer.setName("John" + i);
            customer.setEmail("john" + i + "@gmail.com");
            customer.setCity("Pune");
            customerRepository.save(customer);
        }
    }

    @Test
    public void fetchCustomersByPagination() {
        long count = customerRepository.count();
        int pageSize = 10;
        long pages = count / pageSize;

        for(int i=0; i<pages; i++) {
            Iterable<Customer> custData = customerRepository.findByCity("Pune", PageRequest.of(i, pageSize, Sort.by("name").ascending()));
            for(Customer customer : custData)
                System.out.println(customer);
        }
    }
}
