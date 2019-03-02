package br.com.caelum.cine.session.createMovie;

import br.com.caelum.cine.movies.CreatedMovie;
import br.com.caelum.cine.session.shared.Movie;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class CreatedMovieToMovieConverter implements Converter<CreatedMovie, Movie> {

    @Override
    public Movie convert(CreatedMovie source) {
        return new Movie(source.getId(), source.getDuration(), source.getName());
    }
}
