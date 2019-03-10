package br.com.caelum.cine.configurawtion;

import br.com.caelum.cine.configurawtion.EventBinderConfiguration.EventChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(EventChannel.class)
public class EventBinderConfiguration {

    public static final String SESSION_CHANNEL = "create-sessions";

    interface EventChannel {

        @Input(SESSION_CHANNEL)
        MessageChannel sessionChannel();
    }
}
