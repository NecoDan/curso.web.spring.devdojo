package br.com.curso.web.spring.devdojo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    private DriverManagerDataSource getDataSourceMySQL() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/adota_pet");
        dataSource.setUsername("root");
        dataSource.setPassword("m4st3r.dan");

        return dataSource;
    }

    @Primary
    @Bean
    public DataSource masterMySQLDataSource() {
        return getDataSourceMySQL();
    }

    @Bean
    public DataSource slaveMySQLDataSource() {
        return getDataSourceMySQL();
    }

    @Bean
    public DataSource slave2MySQLDataSource() {
        return getDataSourceMySQL();
    }

    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterMySQLDataSource") DataSource masterMySQLDataSource
            , @Qualifier("slaveMySQLDataSource") DataSource slaveMySQLDataSource
            , @Qualifier("slave2MySQLDataSource") DataSource slave2MySQLDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MYSQL_MASTER, masterMySQLDataSource);
        targetDataSources.put(DBTypeEnum.MYSQL_SLAVE, slaveMySQLDataSource);
        targetDataSources.put(DBTypeEnum.MYSQL_SLAVE2, slave2MySQLDataSource);

        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(masterMySQLDataSource);
        routingDataSource.setTargetDataSources(targetDataSources);

        return routingDataSource;
    }
}
