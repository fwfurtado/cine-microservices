package br.com.caelum.cine.session;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionApplication.class, args);
    }

    @PostConstruct
    void postLoad() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
