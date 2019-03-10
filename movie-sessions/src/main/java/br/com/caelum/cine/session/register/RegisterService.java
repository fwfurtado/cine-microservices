package br.com.caelum.cine.session.register;

import static br.com.caelum.cine.session.configuration.EventBinderConfiguration.SESSION_CHANNEL;

import br.com.caelum.cine.session.configuration.UnavailabilityClient;
import br.com.caelum.cine.session.shared.MovieSession;
import br.com.caelum.cine.session.shared.MovieTheater;
import java.io.Serializable;
import java.time.ZonedDateTime;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private Converter<MovieSessionDTO, MovieSession> converter;
    private RegisterRepository repository;
    private final MessageChannel channel;
    private final UnavailabilityClient unavailabilityClient;

    RegisterService(Converter<MovieSessionDTO, MovieSession> converter, RegisterRepository repository, @Output(SESSION_CHANNEL) MessageChannel channel, UnavailabilityClient unavailabilityClient) {
        this.converter = converter;
        this.repository = repository;
        this.channel = channel;
        this.unavailabilityClient = unavailabilityClient;
    }

    Long register(MovieSessionDTO movieSessionDTO) {
        MovieSession movieSession = converter.convert(movieSessionDTO);

        if (unavailabilityClient.isAvailable(movieSession)) {

            repository.save(movieSession);

            MovieTheater movieTheater = movieSession.getMovieTheater();

            CreatedSession event = new CreatedSession(movieTheater.getId(), movieSession.getDate(), movieSession.getForecastOfEnd());
            channel.send(MessageBuilder.withPayload(event).build());

            return movieSession.getId();
        }

        throw new UnavailablePeriodException();
    }

    private class CreatedSession implements Serializable {

        private final Long theaterId;
        private final ZonedDateTime startDate;
        private final ZonedDateTime endDate;

        CreatedSession(Long theaterId, ZonedDateTime startDate, ZonedDateTime endDate) {

            this.theaterId = theaterId;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Long getTheaterId() {
            return theaterId;
        }

        public ZonedDateTime getStartDate() {
            return startDate;
        }

        public ZonedDateTime getEndDate() {
            return endDate;
        }
    }
}
