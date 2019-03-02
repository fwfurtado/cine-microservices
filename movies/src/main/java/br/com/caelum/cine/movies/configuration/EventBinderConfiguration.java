package br.com.caelum.cine.movies.configuration;

import br.com.caelum.cine.movies.configuration.EventBinderConfiguration.CreatedMovieChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(CreatedMovieChannel.class)
public class EventBinderConfiguration {
    public static final String MOVIE_CHANNEL = "created-movies";

    interface CreatedMovieChannel {
        @Output(MOVIE_CHANNEL)
        MessageChannel channel();
    }
}
