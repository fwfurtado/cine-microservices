package br.com.caelum.cine.movies.register;

import java.time.Duration;
import java.util.StringJoiner;

public class CreatedMovie {

    private Long id;
    private String name;
    private Duration duration;

    /**
     * @deprecated frameworks eyes
     */
    @Deprecated
    CreatedMovie() { }

    public CreatedMovie(Long id, String name, Duration duration) {
        this.id = id;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", CreatedMovie.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("duration=" + duration)
            .toString();
    }
}
