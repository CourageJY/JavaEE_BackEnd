package com.pet.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.pet"})
@EntityScan("com.pet.model")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.pet.minio.controller")
public class minIO {
    public static void main(String[] args)
    {
        SpringApplication.run(minIO.class,args);
    }
}
