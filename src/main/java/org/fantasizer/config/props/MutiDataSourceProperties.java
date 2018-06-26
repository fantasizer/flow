package org.fantasizer.config.props;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 默认多数据源配置
 *
 * @author fengshuonan
 * @date 2017-08-16 10:02
 */
@Component
@ConfigurationProperties(prefix = "guns.muti-datasource")
public class MutiDataSourceProperties {

    private String defaultDataSourceName = "dataSourceGuns";

    private String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/guns?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";

    private String username = "root";

    private String password = "root";

    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    private String validationQuery = "SELECT 'x'";

    public void config(HikariDataSource dataSource) {
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDefaultDataSourceName() {
        return defaultDataSourceName;
    }

    public void setDefaultDataSourceName(String defaultDataSourceName) {
        this.defaultDataSourceName = defaultDataSourceName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }
}
