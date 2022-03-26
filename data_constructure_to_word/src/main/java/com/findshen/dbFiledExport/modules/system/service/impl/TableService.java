package com.findshen.dbFiledExport.modules.system.service.impl;

import com.findshen.dbFiledExport.config.Constants;
import com.findshen.dbFiledExport.modules.system.entity.Tables;
import com.findshen.dbFiledExport.modules.system.mapper.TableMapper;
import com.findshen.dbFiledExport.modules.system.service.ITableService;
import com.findshen.dbFiledExport.utils.DateTimeUtils;
import com.findshen.dbFiledExport.utils.TableToWordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TableService implements ITableService {

    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private TableToWordUtil tableToWordUtil;

    @Override
    public String getTableInfo() {


        List<Tables> t=new ArrayList<>();
        Tables tables=new Tables();
        tables.setTableName("`pigx-iot`");
        tables.setName("sys_project");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigx-iot`");
        tables.setName("sys_project_menu");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigx-iot`");
        tables.setName("iot_monitoring_site");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigxx`");
        tables.setName("sys_role");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigxx`");
        tables.setName("sys_role_menu");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("pigxx");
        tables.setName("sys_user");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigxx`");
        tables.setName("sys_user_role");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigxx`");
        tables.setName("sys_privilege");
        t.add(tables);
        tables=new Tables();
        tables.setTableName("`pigxx`");
        tables.setName("sys_menu");
        t.add(tables);


        // 1、获取数据库所有表信息
        List<Tables> tablesAll = tableMapper.getAllTables(Constants.DATABASE);


        List<Tables> tb=new ArrayList<>();


        for (Tables table : tablesAll) {

            for (Tables tsb : t) {

                if (table.getName().equalsIgnoreCase(tsb.getName())){
                    table.setTableName(tsb.getTableName());
                    tb.add(table);
                }

            }


        }




        // 2、生成文件名信息 - 年月日时分秒
        String date = null;
        try {
            date = DateTimeUtils.dateFormat(new Date(), DateTimeUtils.PARSE_PATTERNS[12]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String docFileName = Constants.FILE_PATH + "\\" + Constants.FILE_NAME + "-" + date + ".doc";

        // 3、调用工具类生成文件
        tableToWordUtil.toWord(tb, docFileName, Constants.FILE_NAME);

        // 4、返回文件地址
        String filePath = docFileName.replaceAll("\\\\", "/");
        return filePath;
    }
}
