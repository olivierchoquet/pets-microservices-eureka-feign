package com.superpets.petservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// Active le client de découverte (Eureka)
@EnableDiscoveryClient
public class PetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetServiceApplication.class, args);
    }

}
