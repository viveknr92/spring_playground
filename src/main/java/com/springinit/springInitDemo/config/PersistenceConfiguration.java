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
//        builder.url("jdbc:mysql://localhost:3306/conference_demo");
//        builder.username("root");
//        builder.password("root");
//        System.out.println("My custom database bean");
//        return builder.build();
//    }
//}
