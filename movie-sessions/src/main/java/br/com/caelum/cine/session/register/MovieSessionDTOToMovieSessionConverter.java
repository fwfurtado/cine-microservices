package br.com.caelum.cine.session.register;

import br.com.caelum.cine.session.register.QueryMovieRepository.MovieNotFoundException;
import br.com.caelum.cine.session.register.QueryMovieTheaterRepository.MovieTheaterNotFoundException;
import br.com.caelum.cine.session.shared.Movie;
import br.com.caelum.cine.session.shared.MovieSession;
import br.com.caelum.cine.session.shared.MovieTheater;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class MovieSessionDTOToMovieSessionConverter implements Converter<MovieSessionDTO, MovieSession> {

    private QueryMovieRepository movieRepository;
    private QueryMovieTheaterRepository theaterRepository;

    MovieSessionDTOToMovieSessionConverter(QueryMovieRepository movieRepository, QueryMovieTheaterRepository theaterRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    @Override
    public MovieSession convert(MovieSessionDTO source) {
        Movie movie = loadMovieFrom(source);

        MovieTheater movieTheater = loadMovieTheaterFrom(source);

        return new MovieSession(movie, movieTheater, source.getDate());
    }

    private MovieTheater loadMovieTheaterFrom(MovieSessionDTO source) {
        Long movieTheaterId = source.getMovieTheaterId();
        return theaterRepository.findById(movieTheaterId).orElseThrow(() -> new MovieTheaterNotFoundException(movieTheaterId));
    }

    private Movie loadMovieFrom(MovieSessionDTO source) {
        Long movieId = source.getMovieId();
        return movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
    }
}
