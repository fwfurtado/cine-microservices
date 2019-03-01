package br.com.caelum.cine.session.shared;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Duration;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Column(name = "movieId")
    private Long id;

    @Column(name = "movieDuration")
    private Duration duration;

    @Column(name = "movieName")
    private String name;

    public Long getId() {
        return id;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }
}
