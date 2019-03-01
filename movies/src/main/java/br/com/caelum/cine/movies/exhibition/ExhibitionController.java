package br.com.caelum.cine.movies.exhibition;

import static org.springframework.http.ResponseEntity.noContent;

import br.com.caelum.cine.movies.MovieController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@MovieController
class ExhibitionController {

    private ExhibitionMovieService service;

    ExhibitionController(ExhibitionMovieService service) {
        this.service = service;
    }

    @PutMapping("{id}/exhibition")
    ResponseEntity<?> onDisplay(@PathVariable Long id) {
        service.onDisplay(id);

        return noContent().build();
    }

    @DeleteMapping("{id}/exhibition")
    ResponseEntity<?> outDisplay(@PathVariable Long id) {
        service.outDisplay(id);

        return noContent().build();
    }

}
