package com.bl.minisms.service;

public interface DataInitialService {
    int init();

    void clearTable(String tableName);

    void setForeignKeyChecks(int value);
}
