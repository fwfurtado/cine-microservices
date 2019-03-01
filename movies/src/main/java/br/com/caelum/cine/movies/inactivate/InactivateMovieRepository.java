package br.com.caelum.cine.movies.inactivate;

import br.com.caelum.cine.movies.shared.Movie;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface InactivateMovieRepository extends Repository<Movie, Long> {

    Optional<Movie> findById(Long id);
}
