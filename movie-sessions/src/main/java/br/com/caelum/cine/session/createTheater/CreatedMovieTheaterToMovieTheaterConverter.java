package br.com.caelum.cine.session.createTheater;

import br.com.caelum.cine.session.shared.MovieTheater;
import br.com.caelum.cine.theater.CreatedMovieTheater;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class CreatedMovieTheaterToMovieTheaterConverter implements Converter<CreatedMovieTheater, MovieTheater> {

    @Override
    public MovieTheater convert(CreatedMovieTheater source) {
       return new MovieTheater(source.getId(), source.getName());
    }
}
