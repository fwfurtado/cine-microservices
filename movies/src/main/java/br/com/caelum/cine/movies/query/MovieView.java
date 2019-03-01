package br.com.caelum.cine.movies.query;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;

interface MovieView {

    Long getId();

    String getName();

    @Value("#{target.exhibition ? 'yes': 'no'}")
    String getInExhibition();

    @Value("#{target.duration.toMinutes() + ' min' }")
    String getDuration();

    @Value("#{target.releaseDate.toLocalDate()}")
    LocalDate getReleaseDate();

}
