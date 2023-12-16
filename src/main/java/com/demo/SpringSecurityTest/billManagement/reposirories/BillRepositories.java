package com.demo.SpringSecurityTest.billManagement.reposirories;

import com.demo.SpringSecurityTest.billManagement.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepositories extends JpaRepository<Bill,Long> {

    List<Bill> findByCustomer_Id_costumer(Long id);
}
