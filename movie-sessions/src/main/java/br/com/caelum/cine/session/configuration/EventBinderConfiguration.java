package br.com.caelum.cine.session.configuration;

import br.com.caelum.cine.session.configuration.EventBinderConfiguration.CreatedEventChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(CreatedEventChannel.class)
public class EventBinderConfiguration {

    public static final String MOVIE_CHANNEL = "created-movies";
    public static final String MOVIE_THEATER_CHANNEL = "created-movie-theaters";
    public static final String SESSION_CHANNEL = "create-sessions";

    interface CreatedEventChannel {

        @Input(MOVIE_CHANNEL)
        MessageChannel movie();

        @Input(MOVIE_THEATER_CHANNEL)
        MessageChannel movieTheater();

        @Output(SESSION_CHANNEL)
        MessageChannel session();
    }
}
