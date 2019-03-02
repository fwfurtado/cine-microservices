package br.com.caelum.cine.session.createMovie;

import br.com.caelum.cine.session.shared.Movie;
import org.springframework.data.repository.Repository;

interface CreateMovieRepository extends Repository<Movie, Long> {

    void save(Movie movie);

    boolean existsById(Long id);
}
