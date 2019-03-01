package br.com.caelum.cine.session.register;

import br.com.caelum.cine.session.shared.MovieSession;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private Converter<MovieSessionDTO, MovieSession> converter;
    private RegisterRepository repository;

    RegisterService(Converter<MovieSessionDTO, MovieSession> converter, RegisterRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    Long register(MovieSessionDTO movieSessionDTO) {
        MovieSession movieSession = converter.convert(movieSessionDTO);

        repository.save(movieSession);

        return movieSession.getId();
    }
}
