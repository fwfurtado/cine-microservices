package br.com.caelum.cine.theater.register;

import br.com.caelum.cine.theater.shared.MovieTheater;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegisterMovieTheaterService {

    private Converter<MovieTheaterDTO, MovieTheater> converter;
    private RegisterMovieTheaterRepository repository;

    RegisterMovieTheaterService(RegisterMovieTheaterRepository repository, Converter<MovieTheaterDTO, MovieTheater> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    Long register(MovieTheaterDTO movieTheaterDTO) {

        MovieTheater movieTheater = converter.convert(movieTheaterDTO);

        repository.save(movieTheater);

        return movieTheater.getId();
    }
}
