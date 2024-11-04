package com.syncapplication.schedulers;

import com.syncapplication.TableNames;
import com.syncapplication.service.ChangeLogService;
import com.syncapplication.service.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Component
public class LegacyChangeScheduler {

    private final PartnerService partnerService;

    private final ChangeLogService changeLogService;

    private final List<String> monitoredTables = List.of(TableNames.CREDITORS.getTableName(), TableNames.DEBITORS.getTableName()); // Add more table names as needed

    @Scheduled(fixedRate = 5000)
    public void checkForChanges() {
        log.info("The scheduled job has been started!");
        for (String tableName : monitoredTables) {
            log.info("Running the SyncService for Table: {}", tableName);
            changeLogService.createChangeLogTableAndTrigger(tableName);
        }
        log.info("Going to process the changes for Partner Entity");
        partnerService.processChanges();
        log.info("The scheduled job has been executed!");
    }
}






