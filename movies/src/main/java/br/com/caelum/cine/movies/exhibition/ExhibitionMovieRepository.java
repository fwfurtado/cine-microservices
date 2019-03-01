package br.com.caelum.cine.movies.exhibition;

import br.com.caelum.cine.movies.shared.Movie;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface ExhibitionMovieRepository extends Repository<Movie, Long> {

    Optional<Movie> findById(Long id);

    void save(Movie movie);
}
