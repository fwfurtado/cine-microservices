package br.com.caelum.cine.session.register;

import br.com.caelum.cine.session.shared.Movie;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface QueryMovieRepository extends Repository<Movie, Long> {

    Optional<Movie> findById(Long id);

    class MovieNotFoundException extends IllegalArgumentException {

        MovieNotFoundException(Long id) {
            super(String.format("Cannot find movie with id '%s", id));
        }
    }
}
