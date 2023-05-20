package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Optional<Customer> findByEmail(String email);

    @Query("select c from Customer c where c.email like %?1%")
    public List<Customer> findByEmailOf(String domain);

    @Query("select c from Customer c where c.city = ?1")
    Page<Customer> findByCity(String city, Pageable pageable);

    @Modifying
    @Query("update Customer c set c.active = false where c.id = ?1")
    void deleteCustomer(int id);
}
