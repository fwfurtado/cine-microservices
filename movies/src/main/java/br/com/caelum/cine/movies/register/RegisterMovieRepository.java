package br.com.caelum.cine.movies.register;

import br.com.caelum.cine.movies.shared.Movie;
import org.springframework.data.repository.Repository;

interface RegisterMovieRepository extends Repository<Movie, Long> {

    void save(Movie movie);
}
