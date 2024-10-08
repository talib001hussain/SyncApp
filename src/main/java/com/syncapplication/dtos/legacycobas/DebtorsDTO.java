package com.syncapplication.dtos.legacycobas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebtorsDTO {
    private Long id;
    private String partnerId;
    private String name;
    private String addressLine1;
    private String city;
    private String postcode;
    private String country;
    private String phone;
    private String email;
    private String website;
    private String faxNumber;
    private String bankAccount;
    private String currency;
    private String language;
    private String debtorNumber;
    private Short multiverseExactSync;
}

