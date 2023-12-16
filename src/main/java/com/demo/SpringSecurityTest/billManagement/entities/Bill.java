package com.demo.SpringSecurityTest.billManagement.entities;

import com.demo.SpringSecurityTest.customerManagement.entities.Customer;
import com.demo.SpringSecurityTest.serializer.CustomerSrializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill", nullable = false)
    private Long id_bill;

    private Double amount;

    private Date payment_date;

    private boolean pay;

    private boolean billing_reminder;

    private String status;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_customer",nullable = false)
    @JsonSerialize(using = CustomerSrializer.class)
    private Customer customer;






}
