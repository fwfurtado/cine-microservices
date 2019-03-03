package br.com.caelum.cine.session.shared;

import java.time.Duration;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private Long id;

    private Duration duration;

    private String name;

    /**
     * @deprecated frameworks eyes
     */
    @Deprecated
    Movie() { }

    public Movie(Long id, Duration duration, String name) {
        this.id = id;
        this.duration = duration;
        this.name = name;
    }

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
