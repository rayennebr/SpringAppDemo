package com.demo.SpringSecurityTest.customerManagement.repositories;

import com.demo.SpringSecurityTest.customerManagement.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
