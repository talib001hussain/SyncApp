package com.syncapplication.schedulers;

import com.syncapplication.TableNames;
import com.syncapplication.util.AppProperties;
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
    private final AppProperties appProperties;

    private final List<String> monitoredTables = List.of(TableNames.CREDITORS.getTableName(), TableNames.DEBITORS.getTableName()); // Add more table names as needed

    @Scheduled(fixedRate = 5000) // will run after 5 seconds
    public void checkForChanges() {
        for (String tableName : monitoredTables) {
            changeLogService.createChangeLogTableAndTrigger(tableName);
        }
        partnerService.processChanges();
    }
}






