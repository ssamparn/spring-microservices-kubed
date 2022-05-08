package com.microservices.kubed.useraccount.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "CUSTOMER_TABLE")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @Column(name = "CUSTOMER_EMAIL")
    private String email;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "CREATION_DATE")
    private LocalDate createDt;
}
