package com.syncapplication.service.impl;

import com.syncapplication.dtos.legacycobas.DebtorsDTO;
import com.syncapplication.entities.Debtors;
import com.syncapplication.mapper.DebtorsMapper;
import com.syncapplication.repository.DebtorsRepository;
import com.syncapplication.service.DebtorsService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DebtorsServiceImpl implements DebtorsService {


    private final EntityManager entityManager;

    private final KafkaTemplate<String, DebtorsDTO> kafkaTemplate;


    private final DebtorsRepository debtorsRepository;


    private final DebtorsMapper debtorsMapper;

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
                DebtorsDTO debtorsDTO = debtorsMapper.toDTO(debtor);

                // Log the type of change
                log.info("Processed {} for record ID: {}", changeType, recordId);

                // Send to Kafka topic
                kafkaTemplate.send(TOPIC, debtorsDTO);

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


