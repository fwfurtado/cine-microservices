package br.com.caelum.cine.movies.inactivate;

import br.com.caelum.cine.movies.MovieNotFoundException;
import br.com.caelum.cine.movies.shared.Movie;
import org.springframework.stereotype.Service;

@Service
class InactivateMovieService {

    private InactivateMovieRepository repository;

    InactivateMovieService(InactivateMovieRepository repository) {
        this.repository = repository;
    }

    void inactivateBy(Long id) {
         Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));

         movie.inactive();
    }
}
