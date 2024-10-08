package com.syncapplication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@Getter
@RequiredArgsConstructor
public enum TableNames {
    CREDITORS("WAYFC01"),
    DEBITORS("WAYFB01");

    private final String tableName;
}
