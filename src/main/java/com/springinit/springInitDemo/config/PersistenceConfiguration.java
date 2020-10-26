//package com.springinit.springInitDemo.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class PersistenceConfiguration {
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.driverClassName("org.postgresql.Driver");
//        builder.url("jdbc:postgres://localhost:5432/conference_demo");
//        builder.username("postgres");
//        builder.password("root");
//        return builder.build();
//    }
//}
