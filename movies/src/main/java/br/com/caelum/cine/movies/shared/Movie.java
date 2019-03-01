package br.com.caelum.cine.movies.shared;

import java.time.Duration;
import java.time.ZonedDateTime;
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
    private ZonedDateTime releaseDate;
    private boolean exhibition;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    Movie() { }

    public Movie(String name, Duration duration, ZonedDateTime releaseDate) {
        this.name = name;
        this.duration = duration;
        this.releaseDate = releaseDate;
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

    public boolean isExhibition() {
        return exhibition;
    }

    public ZonedDateTime getReleaseDate() {
        return releaseDate;
    }

    public void onExhibition() {
        exhibition = true;
    }

    public void outExhibition() {
        exhibition = false;
    }
}
