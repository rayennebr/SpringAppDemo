package com.demo.SpringSecurityTest.promessManagement.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Promess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Promess" , nullable = false)
    private Long idPromess;

    private Date promessDate;

    private Double promessAmount;

    private String status;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_customer",nullable = false)
    @JsonSerialize(using = CustomerSrializer.class)
    private Customer customer;

}
