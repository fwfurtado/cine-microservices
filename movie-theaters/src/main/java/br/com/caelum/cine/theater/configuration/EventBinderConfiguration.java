package br.com.caelum.cine.theater.configuration;

import br.com.caelum.cine.theater.configuration.EventBinderConfiguration.CreatedMovieTheaterChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(CreatedMovieTheaterChannel.class)
public class EventBinderConfiguration {
    public static final String MOVIE_THEATER_CHANNEL = "created-movie-theaters";

    interface CreatedMovieTheaterChannel {
        @Output(MOVIE_THEATER_CHANNEL)
        MessageChannel channel();
    }
}
