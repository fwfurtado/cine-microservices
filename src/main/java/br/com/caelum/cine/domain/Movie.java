package br.com.caelum.cine.domain;

import java.time.Duration;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Duration duration;
    private boolean active = true;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    Movie() { }

    public Movie(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isActive() {
        return active;
    }

    public void inactive() {
        active = false;
    }
}
