package br.com.caelum.cine.movies.inactivate;

import br.com.caelum.cine.domain.Movie;
import br.com.caelum.cine.movies.MovieNotFoundException;
import org.springframework.stereotype.Service;

@Service
class InactivateMovieService {

    private InactivateMovieRepository repository;

    InactivateMovieService(InactivateMovieRepository repository) {
        this.repository = repository;
    }

    void inactivateBy(Long id) {
         Movie movie = repository.findBy(id).orElseThrow(() -> new MovieNotFoundException(id));

         movie.inactive();
    }
}
