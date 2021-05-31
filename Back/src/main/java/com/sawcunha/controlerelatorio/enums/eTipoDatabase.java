package com.sawcunha.controlerelatorio.enums;

public enum eTipoDatabase {
    MYSQL("MySQL"),ORACLE("Oracle"),
    POSTGRESQL("PostgreSQL"),SQLSERVER("SQLServer"),
    MARIADB("MariaDB"), HANA("HANA"), H2("H2");


    private final String database;

    eTipoDatabase(String database) {
        this.database = database;
    }

    public String getDatabase() {
        return database;
    }
}
