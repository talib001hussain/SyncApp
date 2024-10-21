package com.syncapplication.service.impl;

import com.syncapplication.TableNames;
import com.syncapplication.util.AppProperties;
import com.syncapplication.entities.Creditors;
import com.syncapplication.entities.Debtors;
import com.syncapplication.entities.Partner;
import com.syncapplication.mapper.PartnerMapper;
import com.syncapplication.repository.CreditorsRepository;
import com.syncapplication.repository.DebtorsRepository;
import com.syncapplication.service.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PartnerServiceImpl implements PartnerService {

    private final JdbcTemplate jdbcTemplate;

    private final KafkaTemplate<String, Partner> kafkaTemplate;

    private final DebtorsRepository debtorsRepository;

    private final PartnerMapper partnerMapper;
    private final CreditorsRepository creditorsRepository;
    private final AppProperties appProperties;

    @Override
    public void processChanges() {
        // Query to get changes from ChangeLog
        String queryChangeLogSql = "SELECT * FROM ChangeLog";
        List<Map<String, Object>> changeLogs = jdbcTemplate.queryForList(queryChangeLogSql);

        for (Map<String, Object> logEntry : changeLogs) {
            String tableName = (String) logEntry.get("TableName");
            Long recordId = (Long) logEntry.get("RecordID");
            String changeType = (String) logEntry.get("ChangeType");
            Partner partner = null;

            log.info("The Operation Type is: {}", changeType);

            if (TableNames.CREDITORS.getTableName().equalsIgnoreCase(tableName)) {
                Optional<Creditors> creditorOptional = creditorsRepository.findById(BigDecimal.valueOf(recordId));

                if (creditorOptional.isPresent()) {
                    Creditors creditor = creditorOptional.get();
                    partner = partnerMapper.toPartner(creditor);
                    partner.setCreditor(true);
                    log.info("Mapped Creditor to Partner: {}", partner);
                }

            } else if (TableNames.DEBITORS.getTableName().equalsIgnoreCase(tableName)) {
                Optional<Debtors> debtorOptional = debtorsRepository.findById(BigDecimal.valueOf(recordId));

                if (debtorOptional.isPresent()) {
                    Debtors debtor = debtorOptional.get();
                    partner = partnerMapper.toPartnerFromDebtors(debtor);
                    partner.setDebitor(true);
                    log.info("Mapped Debtor to Partner: {}", partner);
                }
            }
            kafkaTemplate.send(appProperties.getPartnerTopic(), partner);
        }
    }
}


