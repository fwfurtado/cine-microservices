package br.com.caelum.cine.movies.register;

import br.com.caelum.cine.movies.shared.Movie;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class MovieDTOToMovieConverter implements Converter<MovieDTO, Movie> {

    @Override
    public Movie convert(MovieDTO source) {
        return new Movie(source.getName(), source.getDuration(), source.getReleaseDate());
    }
}
