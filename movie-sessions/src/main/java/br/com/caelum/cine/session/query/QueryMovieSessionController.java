package br.com.caelum.cine.session.query;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import br.com.caelum.cine.session.MovieSessionController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@MovieSessionController
class QueryMovieSessionController {

    private final QueryMovieSessionRepository repository;

    QueryMovieSessionController(QueryMovieSessionRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    ResponseEntity<?> list() {
        List<SessionView> sessions = repository.listPretty();

        if (sessions.isEmpty()) {
            return notFound().build();
        }

        return ok(sessions);
    }

}
