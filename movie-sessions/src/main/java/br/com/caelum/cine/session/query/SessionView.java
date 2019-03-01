package br.com.caelum.cine.session.query;

import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Value;

interface SessionView {

    Long getId();

    MovieView getMovie();

    @Value("#{target.movieTheater}")
    TheaterView getRoom();

    @Value("#{target}")
    PeriodView getPeriod();

    interface PeriodView {

        @Value("#{target.date}")
        ZonedDateTime getStart();

        @Value("#{target.forecastOfEnd}")
        ZonedDateTime getEnd();
    }

    interface TheaterView {

        String getName();
    }

    interface MovieView {

        String getName();

        @Value("#{target.duration.toMinutes() + ' min'}")
        String getDuration();
    }
}
