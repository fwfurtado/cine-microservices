package br.com.caelum.cine.createSession;

import br.com.caelum.cine.shared.Unavailability;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CreatedMovieSessionToUnavailabilityConverter implements Converter<CreatedMovieSession, Unavailability> {

    @Override
    public Unavailability convert(CreatedMovieSession source) {
        return new Unavailability(source.getTheaterId(), source.getStartDate(), source.getEndDate().plusMinutes(15));
    }
}
