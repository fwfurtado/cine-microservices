package br.com.caelum.cine.session.shared;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieTheater {
    @JsonProperty("name")
    private String theaterName;

    @JsonProperty("id")
    private Long movieTheaterId;

    public String getTheaterName() {
        return theaterName;
    }

    public Long getMovieTheaterId() {
        return movieTheaterId;
    }
}
