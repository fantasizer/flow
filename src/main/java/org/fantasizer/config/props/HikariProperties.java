package org.fantasizer.config.props;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author quxiaoyong 2018/6/22 14:15
 */

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class HikariProperties {

    private String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/guns?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";

    private String username = "root";

    private String password = "root";

    /**
     * mysql8.0开始的driver名称为com.mysql.cj.jdbc.Driver
     */
    private String driverClassName = "com.mysql.cj.jdbc.Driver";


    private Integer minIdle = 1;

    /**
     * 等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException， 缺省:30秒
     */
    private Integer conectionTimeout = 30000;

    /**
     * 一个连接idle状态的最大时长（毫秒），超时则被释放（retired），缺省:10分钟
     */
    private Integer idleTimeout = 600000;

    /**
     * 一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒，
     * 参考MySQL wait_timeout参数（show variables like '%timeout%';）
     */
    private Integer maxLifetime = 1800000;

    /**
     * 连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
     */
    private Integer maximumPoolSize = 20;

    public void config(HikariDataSource dataSource) {

        dataSource.setJdbcUrl(this.jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        dataSource.setMinimumIdle(minIdle);
        dataSource.setConnectionTimeout(conectionTimeout);
        dataSource.setIdleTimeout(idleTimeout);
        dataSource.setMaxLifetime(maxLifetime);
        dataSource.setMaximumPoolSize(maximumPoolSize);

    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
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

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getConectionTimeout() {
        return conectionTimeout;
    }

    public void setConectionTimeout(Integer conectionTimeout) {
        this.conectionTimeout = conectionTimeout;
    }

    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public Integer getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(Integer maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }
}
