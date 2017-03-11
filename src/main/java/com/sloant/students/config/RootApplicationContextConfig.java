package com.sloant.students.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Tim Sloan
 */
@Configuration
@ComponentScan("com.sloant.students")
public class RootApplicationContextConfig {

    @Bean
    public DataSource mysqlDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        /*
            hardcoded for now. Should be refactored out somewhere else
        */
        dataSource.setUrl("jdbc:mysql://localhost:3306/student_reg");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(15);
        dataSource.setMaxOpenPreparedStatements(100);
        return dataSource;
    }
}
