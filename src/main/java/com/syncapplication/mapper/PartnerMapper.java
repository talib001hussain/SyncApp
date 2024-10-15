package com.syncapplication.mapper;

import com.syncapplication.entities.Creditors;
import com.syncapplication.entities.Debtors;
import com.syncapplication.entities.Partner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartnerMapper {

    default Partner toPartner(Creditors creditors) {
        return Partner.builder()
                .partnerId(creditors.getCustomerNumber())
                .name(creditors.getName())
                .searchCode(creditors.getSearchName())
                .faxNumber(creditors.getFaxNumber())
                .email(creditors.getEmailAddress())
                .phone(creditors.getTelephone())
                .website(creditors.getWebsite())
                .addressLine1(creditors.getAddress())
                .city(creditors.getCity())
                .postcode(creditors.getPostalCodeCity())
                .country(String.valueOf(creditors.getCountry()))
                .currency(String.valueOf(creditors.getCurrency()))
                .language(String.valueOf(creditors.getLanguage()))
                .bankAccount(creditors.getBankAccount())
                .isCreditor(true)
                .isDebitor(false)
                .isTransporter(false)
                .build();
    }

    default Partner toPartnerFromDebtors(Debtors debtors) {
        return Partner.builder()
                .id(debtors.getId())
                .partnerId(debtors.getPartnerId())
                .name(debtors.getName())
                .addressLine1(debtors.getAddressLine1())
                .city(debtors.getCity())
                .postcode(debtors.getPostcode())
                .country(debtors.getCountry())
                .phone(debtors.getPhone())
                .email(debtors.getEmail())
                .website(debtors.getWebsite())
                .faxNumber(debtors.getFaxNumber())
                .bankAccount(debtors.getBankAccount())
                .currency(debtors.getCurrency())
                .language(debtors.getLanguage())
                .isCreditor(false)
                .isDebitor(true)
                .isTransporter(false)
                .build();
    }
}



