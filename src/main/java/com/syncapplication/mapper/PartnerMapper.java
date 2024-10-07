package com.syncapplication.mapper;

import com.syncapplication.dtos.legacycobas.CreditorsDTO;
import com.syncapplication.entities.Debtors;
import com.syncapplication.entities.Partner;


public class PartnerMapper {

    public Partner toPartner(CreditorsDTO creditorsDTO) {
        return Partner.builder()
                .partnerId(creditorsDTO.getCustomerNumber())
                .name(creditorsDTO.getName())
                .searchCode(creditorsDTO.getSearchName())
                .faxNumber(creditorsDTO.getFaxNumber())
                .email(creditorsDTO.getEmailAddress())
                .phone(creditorsDTO.getTelephone())
                .website(creditorsDTO.getWebsite())
                .addressLine1(creditorsDTO.getAddress())
                .city(creditorsDTO.getCity())
                .postcode(creditorsDTO.getPostalCodeCity())
                .country(String.valueOf(creditorsDTO.getCountry()))
                .currency(String.valueOf(creditorsDTO.getCurrency()))
                .language(String.valueOf(creditorsDTO.getLanguage()))
                .bankAccount(creditorsDTO.getBankAccount())
                .isCreditor(true)
                .isDebitor(false)
                .isTransporter(false)
                .timeStamp(creditorsDTO.getTimeStamp())
                .build();
    }

    public Partner toPartnerFromDebtors(Debtors debtorsDTO) {
        return Partner.builder()
                .id(debtorsDTO.getId())
                .partnerId(debtorsDTO.getPartnerId())
                .name(debtorsDTO.getName())
                .addressLine1(debtorsDTO.getAddressLine1())
                .city(debtorsDTO.getCity())
                .postcode(debtorsDTO.getPostcode())
                .country(debtorsDTO.getCountry())
                .phone(debtorsDTO.getPhone())
                .email(debtorsDTO.getEmail())
                .website(debtorsDTO.getWebsite())
                .faxNumber(debtorsDTO.getFaxNumber())
                .bankAccount(debtorsDTO.getBankAccount())
                .currency(debtorsDTO.getCurrency())
                .language(debtorsDTO.getLanguage())
                .isCreditor(false)
                .isDebitor(true)
                .isTransporter(false)
                .timeStamp(debtorsDTO.getTimeStamp())
                .build();
    }
}



