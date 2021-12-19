package com.pet.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.pet"})
@EntityScan("com.pet.models")
@EnableDiscoveryClient
public class Community {
    public static void main(String[] args)
    {
        SpringApplication.run(Community.class,args);
    }
}

