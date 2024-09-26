package com.syncapplication.mapper;

import com.syncapplication.dtos.legacycobas.DebtorsDTO;
import com.syncapplication.entities.Debtors;
import org.springframework.stereotype.Component;

@Component
public class DebtorsMapper {

    public DebtorsDTO toDTO(Debtors debtor) {
        DebtorsDTO dto = new DebtorsDTO();
        dto.setRecordNumber(debtor.getRecordNumber());
        dto.setCompany(debtor.getCompany());
        dto.setNumber(debtor.getNumber());
        dto.setName1(debtor.getName1());
        dto.setAddress(debtor.getAddress());
        dto.setCity(debtor.getCity());
        // TODO: Add required/needed attributes
        return dto;
    }

    public Debtors toEntity(DebtorsDTO dto) {
        Debtors debtor = new Debtors();
        debtor.setRecordNumber(dto.getRecordNumber());
        debtor.setCompany(dto.getCompany());
        debtor.setNumber(dto.getNumber());
        debtor.setName1(dto.getName1());
        debtor.setAddress(dto.getAddress());
        debtor.setCity(dto.getCity());
        // TODO: Add required/needed attributes
        return debtor;
    }
}

