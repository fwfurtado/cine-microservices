package br.com.caelum.cine.movies.query;

import br.com.caelum.cine.movies.shared.Movie;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface QueryMovieRepository extends Repository<Movie, Long> {

    Optional<MovieView> findBy(Long id);
}
