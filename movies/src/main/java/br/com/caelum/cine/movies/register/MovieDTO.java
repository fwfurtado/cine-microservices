package br.com.caelum.cine.movies.register;

import java.time.Duration;
import java.time.ZonedDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

class MovieDTO {

    @NotBlank
    private String name;

    @NotNull
    private Duration duration;

    @NotNull
    private ZonedDateTime releaseDate;

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public ZonedDateTime getReleaseDate() {
        return releaseDate;
    }
}
