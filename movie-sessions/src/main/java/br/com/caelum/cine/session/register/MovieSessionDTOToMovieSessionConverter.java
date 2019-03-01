package br.com.caelum.cine.session.register;

import br.com.caelum.cine.session.shared.Movie;
import br.com.caelum.cine.session.shared.MovieSession;
import br.com.caelum.cine.session.shared.MovieTheater;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class MovieSessionDTOToMovieSessionConverter implements Converter<MovieSessionDTO, MovieSession> {

    private MovieRepository movieRepository;
    private MovieTheaterRepository theaterRepository;

    MovieSessionDTOToMovieSessionConverter(MovieRepository movieRepository, MovieTheaterRepository theaterRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    @Override
    public MovieSession convert(MovieSessionDTO source) {
        Movie movie = movieRepository.findById(source.getMovieId());
        MovieTheater movieTheater = theaterRepository.findById(source.getMovieTheaterId());

        return new MovieSession(movie, movieTheater, source.getDate());
    }
}
