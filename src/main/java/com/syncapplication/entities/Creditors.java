package com.syncapplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WAYFC01")
public class Creditors {

    @Id
    @Column(name = "RECNUM")
    private BigDecimal recordNumber;

    @Column(name = "KLANTNUMMER", nullable = false)
    private String customerNumber;

    @Column(name = "NAAM1", nullable = false)
    private String name;

    @Column(name = "ZOEKNAAM")
    private String searchName;

    @Column(name = "FAXNUMMER")
    private String faxNumber;

    @Column(name = "EMAIL_ADRES")
    private String emailAddress;

    @Column(name = "TELEFOON")
    private String telephone;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "ADRES")
    private String address;

    @Column(name = "PKODE_PLAATS")
    private String postalCodeCity;

    @Column(name = "PLAATS")
    private String city;

    @Column(name = "LAND")
    private Short country;

    @Column(name = "VALUTA")
    private Short currency;

    @Column(name = "TAAL")
    private Short language;

    @Column(name = "BANKREKENING")
    private String bankAccount;

    @Column(name = "BICNR")
    private String bicNumber;

}
