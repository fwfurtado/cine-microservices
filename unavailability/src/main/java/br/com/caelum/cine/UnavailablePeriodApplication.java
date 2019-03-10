package br.com.caelum.cine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UnavailablePeriodApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnavailablePeriodApplication.class, args);
    }

}
