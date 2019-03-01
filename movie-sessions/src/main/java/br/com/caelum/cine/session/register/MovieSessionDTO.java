package br.com.caelum.cine.session.register;

import java.time.ZonedDateTime;

class MovieSessionDTO {

    private Long movieId;
    private Long movieTheaterId;
    private ZonedDateTime date;

    public Long getMovieId() {
        return movieId;
    }

    public Long getMovieTheaterId() {
        return movieTheaterId;
    }

    public ZonedDateTime getDate() {
        return date;
    }
}
