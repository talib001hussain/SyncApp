package com.syncapplication;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum TableNames {
    CREDITORS("WAYFC01"),
    DEBITORS("WAYFB01");

    private final String tableName;
}
