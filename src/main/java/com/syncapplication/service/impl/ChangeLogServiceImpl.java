package com.syncapplication.service.impl;

import com.syncapplication.service.ChangeLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ChangeLogServiceImpl implements ChangeLogService {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void createChangeLogTableAndTrigger(String tableName) {
        // Create ChangeLog table if it doesn't exist
        String createTableSql = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='ChangeLog' AND xtype='U') " +
                "CREATE TABLE ChangeLog (" +
                "ChangeID INT IDENTITY(1,1) PRIMARY KEY, " +
                "TableName VARCHAR(255), " +
                "ChangeType VARCHAR(10), " +
                "RecordID BIGINT, " +
                "ChangeTime DATETIME DEFAULT GETDATE())";
        jdbcTemplate.execute(createTableSql);

        // Create Trigger for the specified table
        String createTriggerSql = String.format(
                "CREATE TRIGGER trg_%s_AllChanges " +
                        "ON %s " +
                        "AFTER INSERT, UPDATE, DELETE " +
                        "AS " +
                        "BEGIN " +
                        "    IF EXISTS (SELECT * FROM inserted) " +
                        "    BEGIN " +
                        "        INSERT INTO ChangeLog (TableName, ChangeType, RecordID) " +
                        "        SELECT '%s', 'INSERT', RECNUM FROM inserted; " +
                        "    END " +
                        "    IF EXISTS (SELECT * FROM inserted) AND EXISTS (SELECT * FROM deleted) " +
                        "    BEGIN " +
                        "        INSERT INTO ChangeLog (TableName, ChangeType, RecordID) " +
                        "        SELECT '%s', 'UPDATE', RECNUM FROM inserted; " +
                        "    END " +
                        "    IF EXISTS (SELECT * FROM deleted) " +
                        "    BEGIN " +
                        "        INSERT INTO ChangeLog (TableName, ChangeType, RecordID) " +
                        "        SELECT '%s', 'DELETE', RECNUM FROM deleted; " +
                        "    END " +
                        "END;",
                tableName, tableName, tableName, tableName, tableName
        );
        jdbcTemplate.execute(createTriggerSql);
    }
}
