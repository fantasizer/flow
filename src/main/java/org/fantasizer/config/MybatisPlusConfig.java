package org.fantasizer.config;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.fantasizer.config.datasource.DynamicDataSource;
import org.fantasizer.config.props.HikariProperties;
import org.fantasizer.config.props.MutiDataSourceProperties;
import org.fantasizer.constants.DatasourceEnum;
import org.fantasizer.core.datascope.DataScopeInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;

/**
 * MybatisPlus配置
 *
 * @author quxiaoyong
 * @Date 2017/5/20 21:58
 */
@Configuration
@EnableTransactionManagement(order = 2)//由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@MapperScan("org.fantasizer.dao.mapping.*")
public class MybatisPlusConfig {
    @Autowired
    HikariProperties hikariProperties;

    @Autowired
    MutiDataSourceProperties mutiDataSourceProperties;

    /**
     * 另一个数据源
     */
    private HikariDataSource bizDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        hikariProperties.config(dataSource);
        mutiDataSourceProperties.config(dataSource);
        return dataSource;
    }

    /**
     * guns的数据源
     */
    private HikariDataSource dataSourceGuns() {
        HikariDataSource dataSource = new HikariDataSource();
        hikariProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "false")
    public HikariDataSource singleDatasource() {
        return dataSourceGuns();
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource() {

        HikariDataSource dataSourceGuns = dataSourceGuns();
        HikariDataSource bizDataSource = bizDataSource();

//        try {
//            dataSourceGuns.init();
//            bizDataSource.init();
//        } catch (SQLException sql) {
//            sql.printStackTrace();
//        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap();
        hashMap.put(DatasourceEnum.DATA_SOURCE_GUNS, dataSourceGuns);
        hashMap.put(DatasourceEnum.DATA_SOURCE_BIZ, bizDataSource);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceGuns);
        return dynamicDataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 数据范围mybatis插件
     */
    @Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }

    /**
     * 乐观锁mybatis插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
