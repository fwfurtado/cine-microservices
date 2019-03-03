package br.com.caelum.cine.session.createTheater;

import br.com.caelum.cine.session.configuration.EventBinderConfiguration;
import br.com.caelum.cine.session.shared.MovieTheater;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class CreatedTheaterListener {
    private final CreateMovieTheaterRepository repository;
    private Converter<CreatedMovieTheater, MovieTheater> converter;

    public CreatedTheaterListener(CreateMovieTheaterRepository repository, Converter<CreatedMovieTheater, MovieTheater> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @StreamListener(EventBinderConfiguration.MOVIE_THEATER_CHANNEL)
    void receive(CreatedMovieTheater event) {
        Long movieTheaterId = event.getId();

        if (repository.existsById(movieTheaterId)) {
            throw new MovieTheaterAlreadyExistException(movieTheaterId);
        }

        MovieTheater movieTheater = converter.convert(event);

        repository.save(movieTheater);
    }

    private class MovieTheaterAlreadyExistException extends RuntimeException {

        MovieTheaterAlreadyExistException(Long movieId) {
            super(String.format("Already exist movie theater with id '%s'", movieId));
        }
    }
}
