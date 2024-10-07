package com.syncapplication.schedulers;

import com.syncapplication.service.ChangeLogService;
import com.syncapplication.service.DebtorsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Component
public class LegacyChangeScheduler {

    private final DebtorsService debtorsService;

    private final ChangeLogService changeLogService;

    private final List<String> monitoredTables = List.of("WAYFB01", "WAYFC01"); // Add more table names as needed

    @Scheduled(fixedRate = 5000) // will run after 5 seconds
    public void checkForChanges() {
        for (String tableName : monitoredTables) {
            changeLogService.createChangeLogTableAndTrigger(tableName);
        }
        debtorsService.processChanges();
    }
}






