package br.com.caelum.cine.session.createMovie;

import br.com.caelum.cine.movies.CreatedMovie;
import br.com.caelum.cine.session.configuration.EventBinderConfiguration;
import br.com.caelum.cine.session.shared.Movie;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class CreatedMovieListener {

    private final CreateMovieRepository repository;
    private Converter<CreatedMovie, Movie> converter;

    public CreatedMovieListener(CreateMovieRepository repository, Converter<CreatedMovie, Movie> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @StreamListener(EventBinderConfiguration.MOVIE_CHANNEL)
    void receive(CreatedMovie event) {
        Long movieId = event.getId();

        if (repository.existsById(movieId)) {
            throw new MovieAlreadyExistException(movieId);
        }

        Movie movie = converter.convert(event);

        repository.save(movie);
    }

    private class MovieAlreadyExistException extends RuntimeException {

        MovieAlreadyExistException(Long movieId) {
            super(String.format("Already exist movie with id '%s'", movieId));
        }
    }
}
