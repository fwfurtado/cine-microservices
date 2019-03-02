package br.com.caelum.cine.session.register;

import br.com.caelum.cine.session.shared.MovieTheater;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface QueryMovieTheaterRepository extends Repository<MovieTheater, Long> {

    Optional<MovieTheater> findById(Long id);


    class MovieTheaterNotFoundException extends IllegalArgumentException {

        MovieTheaterNotFoundException(Long id) {
            super(String.format("Cannot find movie theater with id '%s", id));
        }
    }
}
