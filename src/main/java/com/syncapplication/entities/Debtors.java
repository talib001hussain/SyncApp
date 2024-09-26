package com.syncapplication.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WAYFB01")
public class Debtors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECNUM")
    private BigDecimal recordNumber;

    @Column(name = "BEDRIJF")
    private Short company;

    @Column(name = "NUMMER")
    private Integer number;

    @Column(name = "NAAM1")
    private String name1;

    @Column(name = "NAAM2")
    private String name2;

    @Column(name = "ADRES")
    private String address;

    @Column(name = "PLAATS")
    private String city;

    @Column(name = "PKODE_PLAATS")
    private String cityPostalCode;

    @Column(name = "POSTBUS")
    private Integer poBox;

    @Column(name = "POSTBUS_PLAATS")
    private String poBoxCity;

    @Column(name = "PKODE_POSTBUS")
    private String poBoxPostalCode;

    @Column(name = "ZOEKNAAM")
    private String searchName;

    @Column(name = "TELEFOON")
    private String phone;

    @Column(name = "EMAIL_ADRES")
    private String emailAddress;

    @Column(name = "KONTAKTPERSOON")
    private String contactPerson;

    @Column(name = "TELEFOON_KONTAK")
    private String contactPhone;

    @Column(name = "E_MAIL_KONTAK")
    private String contactEmail;

    @Column(name = "BANKREKENING")
    private String bankAccount;

    @Column(name = "GIROREKENING")
    private String giroAccount;

    @Column(name = "BEDRIJF_LAND")
    private Short companyCountry;

    @Column(name = "LAND")
    private Short country;

    @Column(name = "BEDRIJF_TAAL")
    private Short companyLanguage;

    @Column(name = "TAAL")
    private Short language;

    @Column(name = "BEDRIJF_LEVK")
    private Short companySupplier;

    @Column(name = "LEV_KOND")
    private Short supplierCondition;

    @Column(name = "BET_KOND")
    private Short paymentCondition;

    @Column(name = "BEDRIJF_RAYON")
    private Short companyRegion;

    @Column(name = "RAYON")
    private Short region;

    @Column(name = "AFN_KAT")
    private Short customerCategory;

    @Column(name = "BEDRIJF_VERK")
    private Short companySalesperson;

    @Column(name = "VERKOPER")
    private Short salesperson;

    @Column(name = "PRIJSTABEL")
    private Short priceTable;

    @Column(name = "FAKTUURKORTING")
    private BigDecimal invoiceDiscount;

    @Column(name = "VERZ_FAKTUUR")
    private Short invoiceShipping;

    @Column(name = "RES_KODE1")
    private Integer reserveCode1;

    @Column(name = "BEDRIJF_VALUTA")
    private Short companyCurrency;

    @Column(name = "VALUTA")
    private Short currency;

    @Column(name = "BLOKKADE")
    private String blockade;

    @Column(name = "BTW")
    private Short vat;

    @Column(name = "REKENINGOVERZ")
    private String accountOverview;

    @Column(name = "KREDIETTERMIJN")
    private Short creditTerm;

    @Column(name = "KREDIETLIMIET")
    private Integer creditLimit;

    @Column(name = "KREDIETBEPERK")
    private BigDecimal creditRestriction;

    @Column(name = "OPENST_SALDO")
    private BigDecimal outstandingBalance;

    @Column(name = "OPENST_DAGEN")
    private Integer outstandingDays;

    @Column(name = "OPENST_BET")
    private Short outstandingPayment;

    @Column(name = "FAXNUMMER")
    private String faxNumber;

    @Column(name = "KWALITEITS")
    private String quality;

    @Column(name = "BEDRIJF_EXPEDIT")
    private Short companyExpedition;

    @Column(name = "EXPEDITEUR")
    private Short forwarder;

    @Column(name = "IND_HNDKRT")
    private String indicatorHandCard;

    @Column(name = "IND_SURPLUS")
    private String indicatorSurplus;

    @Column(name = "BTWNUMMER")
    private String vatNumber;

    @Column(name = "SOORT_DEB")
    private String typeDebtor;

    @Column(name = "BTW2")
    private Short vat2;

    @Column(name = "DEB_KODE")
    private Short debtorCode;

    @Column(name = "ZIP_KODE")
    private Short zipCode;

    @Column(name = "ZIP_VOLGNR")
    private Short zipSequenceNumber;

    @Column(name = "IND_INDELING")
    private String indicatorClassification;

    @Column(name = "IND_POSTKODE")
    private String indicatorPostalCode;

    @Column(name = "ZONE")
    private Short zone;

    @Column(name = "TREFNAAM")
    private String referenceName;

    @Column(name = "PVS_TYPE_DEB")
    private Short pvsTypeDebtor;

    @Column(name = "INGANGSDATUM")
    private LocalDateTime startDate;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "HANDELSKRTNR")
    private Short tradeCardNumber;

    @Column(name = "DATUM_HNDKRT")
    private LocalDateTime tradeCardDate;

    @Column(name = "EXP_VERKL")
    private String exportDeclaration;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "DEBITEURNR")
    private String debtorNumber;

    @Column(name = "ORDERNUMMER")
    private String orderNumber;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "FACTUURTEKST")
    private String invoiceText;

    @Column(name = "VERVOER")
    private String transport;

    @Column(name = "FRANKERING")
    private String franking;

    @Column(name = "EXTRA_TEL_1")
    private String extraPhone1;

    @Column(name = "EXTRA_TEL_2")
    private String extraPhone2;

    @Column(name = "EXTRA_TEL_3")
    private String extraPhone3;

    @Column(name = "CATALOGUS")
    private String catalog;

    @Column(name = "NUMMER_VANAF")
    private Integer numberFrom;

    @Column(name = "CREDITEURNUMMER", nullable = false)
    private BigDecimal creditorNumber;

    @Column(name = "BTWPLICHTIG", nullable = false)
    private String vatLiable;

    @Column(name = "PERMITNR")
    private String permitNumber;

    @Column(name = "BESTEMMING")
    private BigDecimal destination;

    @Column(name = "ADRES2")
    private String address2;

    @Column(name = "FUSTCODE")
    private BigDecimal packagingCode;

    @Column(name = "BET_GEDRAG")
    private BigDecimal paymentBehavior;

    @Column(name = "OPSLAG")
    private BigDecimal storage;

    @Column(name = "OPSLAG_1")
    private BigDecimal storage1;

    @Column(name = "OPSLAG_2")
    private BigDecimal storage2;

    @Column(name = "OPSLAG_3")
    private BigDecimal storage3;

    @Column(name = "OPSLAG_4")
    private BigDecimal storage4;

    @Column(name = "OPSLAG_5")
    private BigDecimal storage5;

    @Column(name = "OPSLAG_6")
    private BigDecimal storage6;

    @Column(name = "OPSLAG_7")
    private BigDecimal storage7;

    @Column(name = "OPSLAG_8")
    private BigDecimal storage8;

    @Column(name = "OPSLAG_9")
    private BigDecimal storage9;

    @Column(name = "OPSLAG_10")
    private BigDecimal storage10;

    @Column(name = "BANKNAAM")
    private String bankName;

    @Column(name = "POSTADRES")
    private String postalAddress;

    @Column(name = "FACTUURCOND")
    private BigDecimal invoiceCondition;

    @Column(name = "MULTIVERS")
    private String multivers;

    @Column(name = "CRM_ACTIEF")
    private String crmActive;

    @Column(name = "BED_BUND", nullable = false)
    private BigDecimal companyBundle;

    @Column(name = "BUNDEL", nullable = false)
    private BigDecimal bundle;

    @Column(name = "KR_AANGESLOTEN", nullable = false)
    private Byte krConnected;

    @Column(name = "TUSSENPERSOON_1", nullable = false)
    private BigDecimal intermediary1;

    @Column(name = "PROV_1", nullable = false)
    private BigDecimal commission1;

    @Column(name = "TUSSENPERSOON_2", nullable = false)
    private BigDecimal intermediary2;

    @Column(name = "PROV_2", nullable = false)
    private BigDecimal commission2;

    @Column(name = "DFLT_SEIZOEN", nullable = false)
    private BigDecimal defaultSeason;

    @Column(name = "DFLT_ORDER", nullable = false)
    private Integer defaultOrder;

    @Column(name = "NAJR_SEIZOEN", nullable = false)
    private BigDecimal autumnSeason;

    @Column(name = "NAJR_ORDER", nullable = false)
    private BigDecimal autumnOrder;

    @Column(name = "KVK_NUMMER")
    private String chamberOfCommerceNumber;

    @Column(name = "IND_LOGO")
    private String indicatorLogo;

    @Column(name = "IND_SPOELEN")
    private String indicatorRinse;

    @Column(name = "PRINTERKODE")
    private Byte printerCode;

    @Column(name = "STD_CATEG")
    private Short standardCategory;

    @Column(name = "KR_LAND", nullable = false)
    private BigDecimal krCountry;

    @Column(name = "IND_LOGO_PALLETKAART")
    private String indicatorLogoPalletCard;

    @Column(name = "IND_STAPELKAART")
    private String indicatorStackCard;

    @Column(name = "MAIL_ONDERWERP")
    private String mailSubject;

    @Column(name = "MULTIVERS_EXACT_SYNC")
    private Short multiversExactSync;
}

