package br.com.caelum.cine.movies.inactivate;

import static org.springframework.http.ResponseEntity.noContent;

import br.com.caelum.cine.movies.MovieController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@MovieController
class InactivateController {

    private InactivateMovieService service;

    InactivateController(InactivateMovieService service) {
        this.service = service;
    }

    @PutMapping("{id}")
    ResponseEntity<?> inactivate(@PathVariable Long id) {
        service.inactivateBy(id);

        return noContent().build();
    }

}
