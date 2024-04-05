package com.sunbase.sunbaseProject.Repository;

import com.sunbase.sunbaseProject.Entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Custom method to retrieve all customers with pagination.
    Page<Customer> findAll(Pageable pageable);

    // Custom query to search for customers by first name, last name, or email using a case-insensitive search.
    @Query("SELECT c FROM Customer c WHERE LOWER(c.first_name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(c.last_name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(c.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(c.state) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(c.city) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(c.street) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Customer> searchCustomers(@Param("searchTerm") String searchTerm);
    


}

