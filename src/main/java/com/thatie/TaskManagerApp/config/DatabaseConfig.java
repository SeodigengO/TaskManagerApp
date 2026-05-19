package com.thatie.TaskManagerApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean

    public JdbcTemplate jdbcTemplate(final DatabaseConfig dataSource){
        return new JdbcTemplate((DataSource) dataSource);
    }
}
