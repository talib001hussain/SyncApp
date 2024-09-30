package com.syncapplication.repository;

import com.syncapplication.entities.Debtors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DebtorsRepository extends JpaRepository<Debtors, BigDecimal> {

}

