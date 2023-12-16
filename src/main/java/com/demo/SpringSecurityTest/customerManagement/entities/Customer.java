package com.demo.SpringSecurityTest.customerManagement.entities;

import com.demo.SpringSecurityTest.billManagement.entities.Bill;
import com.demo.SpringSecurityTest.promessManagement.entity.Promess;
import com.demo.SpringSecurityTest.serializer.BillSerializer;
import com.demo.SpringSecurityTest.serializer.PromessSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name="customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costumer", nullable = false)
    private Long id_costumer;

    private String name;

    private String id_fs;

    private String email;

    private String rso;

    private String phone_number;

    private String status;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;

    @OneToMany(mappedBy = "customer")
    @JsonSerialize(using = BillSerializer.class)
    private List<Bill> bills;

    @OneToMany(mappedBy = "customer")
    @JsonSerialize(using = PromessSerializer.class)
    private List<Promess> promess;


}
