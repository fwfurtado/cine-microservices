package br.com.caelum.cine.movies.inactivate;

import br.com.caelum.cine.domain.Movie;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface InactivateMovieRepository extends Repository<Movie, Long> {

    Optional<Movie> findBy(Long id);
}
