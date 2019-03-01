package br.com.caelum.cine.theater.register;

import br.com.caelum.cine.theater.shared.MovieTheater;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class MovieTheaterDTOToMovieTheaterConverter implements Converter<MovieTheaterDTO, MovieTheater> {

    @Override
    public MovieTheater convert(MovieTheaterDTO source) {
        return new MovieTheater(source.getName(), source.getType(), source.getSeatsNumber());
    }
}
