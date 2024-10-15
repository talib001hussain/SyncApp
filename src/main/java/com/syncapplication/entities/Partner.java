package com.syncapplication.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Partner {

    private Long id;
    private String partnerId;

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
    private boolean isCreditor;
    private boolean isDebitor;
    private boolean isTransporter;

    private String orgId;
    private LocalDateTime timeStamp;

}
