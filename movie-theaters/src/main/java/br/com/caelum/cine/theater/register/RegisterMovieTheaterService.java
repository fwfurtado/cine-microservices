package br.com.caelum.cine.theater.register;

import static br.com.caelum.cine.theater.configuration.EventBinderConfiguration.MOVIE_THEATER_CHANNEL;

import br.com.caelum.cine.theater.shared.MovieTheater;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
class RegisterMovieTheaterService {

    private Converter<MovieTheaterDTO, MovieTheater> converter;
    private final MessageChannel channel;
    private RegisterMovieTheaterRepository repository;


    RegisterMovieTheaterService(RegisterMovieTheaterRepository repository, Converter<MovieTheaterDTO, MovieTheater> converter, @Output(MOVIE_THEATER_CHANNEL) MessageChannel channel) {
        this.repository = repository;
        this.converter = converter;
        this.channel = channel;
    }

    Long register(MovieTheaterDTO movieTheaterDTO) {

        MovieTheater movieTheater = converter.convert(movieTheaterDTO);

        repository.save(movieTheater);

        CreatedMovieTheater event = new CreatedMovieTheater(movieTheater.getId(), movieTheater.getName());

        channel.send(MessageBuilder.withPayload(event).build());

        return movieTheater.getId();
    }
}
