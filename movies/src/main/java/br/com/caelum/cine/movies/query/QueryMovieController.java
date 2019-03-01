package br.com.caelum.cine.movies.query;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import br.com.caelum.cine.movies.MovieController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@MovieController
class QueryMovieController {

    private QueryMovieService service;

    QueryMovieController(QueryMovieService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    ResponseEntity<MovieView> show(@PathVariable Long id) {
        return service
                .findMovieBy(id)
                    .map(ok()::body)
                        .orElseGet(notFound()::build);
    }
}
