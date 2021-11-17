package com.findshen.dbFiledExport.modules.system.mapper;


import com.findshen.dbFiledExport.modules.system.entity.TableFileds;
import com.findshen.dbFiledExport.modules.system.entity.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TableMapper {

    /**
     * 获取指定数据库下所有表名和注释
     *
     * @param dbName:数据库名
     * @return: java.util.List<com.zhengqing.demo.modules.system.entity.Tables>
     */
    @Select("select table_name as name,table_comment as comment from information_schema.tables \n" +
            "where table_schema in('pigxx','pigx-iot') order by table_name")
    List<Tables> getAllTables(@Param("dbName") String dbName);

    /**
     * 获取指定表信息
     *
     * @param tableName:表
     * @return: java.util.List<com.zhengqing.demo.modules.system.entity.TableFileds>
     */
    @Select("SHOW FULL FIELDS FROM ${dbName}.${tableName}")
    List<TableFileds> getTable(@Param("dbName") String dbName,@Param("tableName") String tableName);

}
