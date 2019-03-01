package br.com.caelum.cine.session;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSessionApplication.class, args);
    }

    @PostConstruct
    void postLoad() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
