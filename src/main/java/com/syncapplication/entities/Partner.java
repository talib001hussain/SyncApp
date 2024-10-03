package com.syncapplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Partner {

    private Long id;
    @Column(nullable = false)
    private String partnerId;

    @Column(nullable = false)
    private String name;
    private String searchCode;
    private String code;
    private String fax;
    private String email;
    private String phone;
    private String website;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String city;
    private String country;
    private String faxNumber;
    private String currency;
    private String language;
    private String bankAccountId;
    private String bankAccount;
    private String bicCode;

    @Column(nullable = false)
    private boolean isCreditor;

    @Column(nullable = false)
    private boolean isDebitor;

    @Column(nullable = false)
    private boolean isTransporter;

    private String orgId;

}
