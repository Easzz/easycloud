package com.findshen.dbFiledExport.modules.system.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Tables {


    private String tableName;

    /**
     * 表名
     */
    private String name;
    /**
     * 表注释
     */
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tables)) return false;
        Tables tables = (Tables) o;
        return Objects.equals(name, tables.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
