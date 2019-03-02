package br.com.caelum.cine.movies.register;

import static br.com.caelum.cine.movies.configuration.EventBinderConfiguration.MOVIE_CHANNEL;

import br.com.caelum.cine.movies.shared.Movie;
import java.io.Serializable;
import java.time.Duration;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private final RegisterMovieRepository repository;
    private final Converter<MovieDTO, Movie> converter;
    private final MessageChannel channel;

    RegisterService(RegisterMovieRepository repository, Converter<MovieDTO, Movie> converter, @Input(MOVIE_CHANNEL) MessageChannel channel) {
        this.repository = repository;
        this.converter = converter;
        this.channel = channel;

    }

    Long registerBy(MovieDTO movieDTO) {
        Movie movie = converter.convert(movieDTO);

        repository.save(movie);

        CreatedMovieEvent event = new CreatedMovieEvent(movie);

        channel.send(MessageBuilder.withPayload(event).build());

        return movie.getId();
    }

    class CreatedMovieEvent implements Serializable {

        private final Movie movie;

        CreatedMovieEvent(Movie movie) {
            this.movie = movie;
        }

        public Long getId() {
            return movie.getId();
        }

        public String getName() {
            return movie.getName();
        }

        public Duration getDuration() {
            return movie.getDuration();
        }
    }
}
