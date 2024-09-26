package com.syncapplication.repository;

import com.syncapplication.entities.Debtors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface DebtorsRepository extends JpaRepository<Debtors, BigDecimal> {

}

