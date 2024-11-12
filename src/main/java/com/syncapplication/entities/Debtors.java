package com.syncapplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WAYFB01")
public class Debtors {

    @Id
    @Column(name = "RECNUM")
    private Long id;

    @Column(name = "NUMMER")
    private String partnerId;

    @Column(name = "NAAM1")
    private String name;

    @Column(name = "ADRES")
    private String addressLine1;

    @Column(name = "PLAATS")
    private String city;

    @Column(name = "PKODE_PLAATS")
    private String postcode;

    @Column(name = "LAND")
    private String country;

    @Column(name = "TELEFOON")
    private String phone;

    @Column(name = "EMAIL_ADRES")
    private String email;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "FAXNUMMER")
    private String faxNumber;

    @Column(name = "BANKREKENING")
    private String bankAccount;

    @Column(name = "VALUTA")
    private String currency;

    @Column(name = "TAAL")
    private String language;

    @Column(name = "DEBITEURNR")
    private String debtorNumber;
}

