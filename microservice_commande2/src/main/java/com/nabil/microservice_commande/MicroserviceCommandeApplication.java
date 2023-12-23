package com.nabil.microservice_commande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// pour Spring Cloud Config
@EnableConfigurationProperties
// pour Eureka Client
@EnableDiscoveryClient

public class MicroserviceCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCommandeApplication.class, args);
    }

}
