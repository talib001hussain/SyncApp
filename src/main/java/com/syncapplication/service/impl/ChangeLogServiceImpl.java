package com.syncapplication.service.impl;

import com.syncapplication.service.ChangeLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChangeLogServiceImpl implements ChangeLogService {

    private final JdbcTemplate jdbcTemplate;

    public void createChangeLogTableAndTrigger(String tableName) {
        // Check if ChangeLog table exists using INFORMATION_SCHEMA.TABLES
        String checkTableExistsSql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'ChangeLog'";
        Integer tableCount = jdbcTemplate.queryForObject(checkTableExistsSql, Integer.class);

        // Create ChangeLog table if it doesn't exist
        if (tableCount == 0) {
            String createTableSql = "CREATE TABLE ChangeLog (" +
                    "ChangeID INT IDENTITY(1,1) PRIMARY KEY, " +
                    "TableName NVARCHAR(255), " +
                    "ChangeType NVARCHAR(10), " +
                    "RecordID BIGINT, " +
                    "ChangeTime DATETIME DEFAULT GETDATE())";

            // Log the SQL statement
            log.info("Executing SQL: {}", createTableSql);

            // Execute the CREATE TABLE command
            try {
                jdbcTemplate.execute(createTableSql);
            } catch (BadSqlGrammarException e) {
                log.error("Error executing create table SQL {}", e.toString());
                throw e;
            }
        } else {
            log.info("ChangeLog table already exists.");
        }

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

        // Log the trigger creation SQL
        log.info("Executing SQL for creating trigger: {}", createTriggerSql);

        // Execute the trigger creation
        jdbcTemplate.execute(createTriggerSql);
    }








}
