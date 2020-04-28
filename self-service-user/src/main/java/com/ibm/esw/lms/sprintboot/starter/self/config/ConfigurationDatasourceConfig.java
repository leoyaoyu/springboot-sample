package com.ibm.esw.lms.sprintboot.starter.self.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigurationDatasourceConfig {

    @Bean("solution-db")
    @ConfigurationProperties(prefix = "spring.datasource.solution-db")
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        //hikariDataSource.setConnectionTestQuery("SELECT current date FROM sysibm.sysdummy1");
        return hikariDataSource;
    }

}