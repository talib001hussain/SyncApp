package com.syncapplication.repository;

import com.syncapplication.entities.Creditors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CreditorsRepository extends JpaRepository<Creditors, BigDecimal> {
    Optional<Creditors> findByRecordNumber(BigDecimal recordNumber);

}

