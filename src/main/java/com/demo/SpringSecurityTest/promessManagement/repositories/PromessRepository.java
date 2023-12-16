package com.demo.SpringSecurityTest.promessManagement.repositories;

import com.demo.SpringSecurityTest.promessManagement.entity.Promess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromessRepository extends JpaRepository<Promess,Long> {
}
