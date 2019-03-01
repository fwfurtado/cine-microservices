package br.com.caelum.cine.theater.query;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import br.com.caelum.cine.theater.MovieTheaterController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@MovieTheaterController
class QueryMovieTheaterController {

    private QueryMovieTheaterRepository repository;

    QueryMovieTheaterController(QueryMovieTheaterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<?> list() {

        List<MovieTheaterView> movies = repository.findAll();

        if (movies.isEmpty()) {
            return notFound().build();
        }

        return ok(movies);
    }

    @GetMapping("{id}")
    ResponseEntity<MovieTheaterView> show(@PathVariable Long id) {
        return repository.findTheaterViewById(id).map(ok()::body).orElseGet(notFound()::build);
    }

}
