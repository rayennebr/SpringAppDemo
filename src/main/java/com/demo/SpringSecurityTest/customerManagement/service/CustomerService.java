package com.demo.SpringSecurityTest.customerManagement.service;

import com.demo.SpringSecurityTest.customerManagement.entities.Customer;
import com.demo.SpringSecurityTest.customerManagement.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer)
    {
        return this.customerRepository.save(customer);
    }

    public List<Customer>getAllCustomers(){
        return this.customerRepository.findAll();
    }

    public Customer deleteCustomer(Long id)
    {
        Optional<Customer> customer = this.customerRepository.findById(id);
        this.customerRepository.delete(customer.get());
        return customer.get();
    }

    public Customer updateCustomer(Customer customer)
    {
        Optional<Customer> currentCustomer = this.customerRepository.findById(customer.getId_costumer());
        if(currentCustomer.isPresent())
        {
            this.customerRepository.saveAndFlush(customer);
            return currentCustomer.get();
        }
        else return null;
    }
}
