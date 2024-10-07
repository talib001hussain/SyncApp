package com.syncapplication.service.impl;

import com.syncapplication.entities.Debtors;
import com.syncapplication.entities.Partner;
import com.syncapplication.mapper.PartnerMapper;
import com.syncapplication.repository.DebtorsRepository;
import com.syncapplication.service.DebtorsService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DebtorsServiceImpl implements DebtorsService {


    private final EntityManager entityManager;

    private final KafkaTemplate<String, Partner> kafkaTemplate;


    private final DebtorsRepository debtorsRepository;


    private final PartnerMapper partnerMapper;

    private static final String TOPIC = "debtors_topic";

    @Override
    public void processChanges() {
        Query query = entityManager.createNativeQuery("SELECT * FROM ChangeLog");
        List<Object[]> changes = query.getResultList();

        for (Object[] change : changes) {
            String tableName = (String) change[1];
            String changeType = (String) change[2];
            BigDecimal recordId = (BigDecimal) change[3];

            // Fetch the record from the relevant table
            Debtors debtor = fetchRecordFromTable(tableName, recordId);
            if (debtor != null) {
                Partner partnerFromDebtors = partnerMapper.toPartnerFromDebtors(debtor);

                // Log the type of change
                log.info("Processed {} for record ID: {}", changeType, recordId);

                // Send to Kafka topic
                kafkaTemplate.send(TOPIC, partnerFromDebtors);

                // Save to PostgreSQL
                debtorsRepository.save(debtor);

            }

            // Remove processed change log entry
            entityManager.createNativeQuery("DELETE FROM ChangeLog WHERE ChangeID = :changeId")
                    .setParameter("changeId", change[0])
                    .executeUpdate();
        }
    }

    private Debtors fetchRecordFromTable(String tableName, BigDecimal recordId) {
        if (tableName.equalsIgnoreCase("WAYFB01")) {
            return debtorsRepository.findById(recordId).orElse(null);
        }
        // TODO: the logic will be handled here for filtering different tables
        return null;
    }
}


