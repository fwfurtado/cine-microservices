package br.com.caelum.cine.movies.register;

import br.com.caelum.cine.domain.Movie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private final RegisterMovieRepository repository;
    private final Converter<MovieDTO, Movie> converter;

    RegisterService(RegisterMovieRepository repository, Converter<MovieDTO, Movie> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    Long registerBy(MovieDTO movieDTO) {
        Movie movie = converter.convert(movieDTO);

        repository.save(movie);

        return movie.getId();
    }
}
