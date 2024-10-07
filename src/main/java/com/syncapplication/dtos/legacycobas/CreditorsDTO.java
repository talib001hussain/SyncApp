package com.syncapplication.dtos.legacycobas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditorsDTO {

    private String customerNumber;
    private String name;
    private String searchName;
    private String faxNumber;
    private String emailAddress;
    private String telephone;
    private String website;
    private String address;
    private String postalCodeCity;
    private String city;
    private Short country;
    private Short currency;
    private Short language;
    private String bankAccount;
    private String bicNumber;
    private Short multiverseExactSync;
    private LocalDateTime timeStamp;
}
