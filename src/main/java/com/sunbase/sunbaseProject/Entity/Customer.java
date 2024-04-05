package com.sunbase.sunbaseProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    // Primary key for the customer entity, auto-generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid = String.valueOf(UUID.randomUUID());

    private String first_name;

    private String last_name;

    private String street;

    private String address;

    private String city;

    private String state;

    private String email;

    private String phone;


}
