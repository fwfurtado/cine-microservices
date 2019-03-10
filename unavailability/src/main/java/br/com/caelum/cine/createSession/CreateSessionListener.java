package br.com.caelum.cine.createSession;

import br.com.caelum.cine.configurawtion.EventBinderConfiguration;
import br.com.caelum.cine.shared.Unavailability;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class CreateSessionListener {

    private final CreateUnavailabilityRepository repository;
    private final Converter<CreatedMovieSession, Unavailability> converter;

    CreateSessionListener(CreateUnavailabilityRepository repository, Converter<CreatedMovieSession, Unavailability> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @StreamListener(EventBinderConfiguration.SESSION_CHANNEL)
    void receive(CreatedMovieSession event) {
        Unavailability unavailability = converter.convert(event);

        repository.save(unavailability);
    }
}
