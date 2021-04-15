package com.lbarros.microservicio.alumnos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.lbarros.microservicio.alumnos.repository")
public class MongoConfig extends AbstractMongoConfiguration {
  
    @Override
    protected String getDatabaseName() {
        return "universidadMicroservicio";
    }
  
    @Bean
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }
}