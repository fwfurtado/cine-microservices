package br.com.caelum.cine.movies.register;

import static org.springframework.http.ResponseEntity.created;

import br.com.caelum.cine.movies.MovieController;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@MovieController
class RegisterMovieController {

    private final RegisterService service;

    RegisterMovieController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> register(@Valid MovieDTO movieDTO, ServletUriComponentsBuilder uriComponentsBuilder) {
        Long id = service.registerBy(movieDTO);

        URI uri = uriComponentsBuilder.path("/movies/{id}").buildAndExpand(id).toUri();

        return created(uri).build();
    }
}
