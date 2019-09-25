package com.findshen.modules.bz.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * mybatis plus 插件配置类
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
//     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //多租户,在解析sql时设置
//        ArrayList<ISqlParser> sqlParsers = new ArrayList<>();
//        TenantSqlParser tenantSqlParser = new TenantSqlParser();
//        tenantSqlParser.setTenantHandler(new TenantHandler() {
//            @Override
//            public Expression getTenantId() {
//                //读取当前用户所属租户
//                //获取租户值，从session或配置文件等处取出
//                return new LongValue(1L);
//            }
//
//            @Override
//            public String getTenantIdColumn() {
//                //设置多租户字段
//                return "manager_id";
//            }
//
//            @Override
//            public boolean doTableFilter(String tableName) {
//                //若某些表不需要增加租户信息，则return true
//                if ("role".equals(tableName)) {
//                    return true;
//                }
//                return false;
//            }
//        });
//        sqlParsers.add(tenantSqlParser);
//        paginationInterceptor.setSqlParserList(sqlParsers);

//        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
//            @Override
//            public boolean doFilter(MetaObject metaObject) {
//                return false;
//            }
//        });

        return paginationInterceptor;
    }

    /**
     * 性能分析插件
     * 开发环境使用
     *
     * @return
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //格式化sql
        performanceInterceptor.setFormat(true);
        //最大执行时间，超过则失败
        //performanceInterceptor.setMaxTime(1);
        return performanceInterceptor;
    }

    /**
     * 乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
