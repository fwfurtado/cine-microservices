package br.com.caelum.cine.movies.query;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import br.com.caelum.cine.movies.MovieController;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@MovieController
class QueryMovieController {

    private QueryMovieRepository repository;

    QueryMovieController(QueryMovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    ResponseEntity<?> show(@PathVariable Long id) {
        Optional<MovieView> movieView = repository.findMovieViewById(id);

        return  movieView.map(ok()::body).orElseGet(notFound()::build);
    }
}
