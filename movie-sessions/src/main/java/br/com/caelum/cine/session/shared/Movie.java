package br.com.caelum.cine.session.shared;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import javax.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @JsonProperty("id")
    private Long movieId;

    @JsonProperty("duration")
    private Duration movieDuration;

    public Long getMovieId() {
        return movieId;
    }

    public Duration getMovieDuration() {
        return movieDuration;
    }
}
