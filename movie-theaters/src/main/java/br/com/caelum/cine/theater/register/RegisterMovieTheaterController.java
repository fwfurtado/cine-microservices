package br.com.caelum.cine.theater.register;

import static org.springframework.http.ResponseEntity.created;

import br.com.caelum.cine.theater.MovieTheaterController;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@MovieTheaterController
class RegisterMovieTheaterController {

    private RegisterMovieTheaterService service;

    RegisterMovieTheaterController(RegisterMovieTheaterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody MovieTheaterDTO movieTheaterDTO, ServletUriComponentsBuilder uriComponentsBuilder) {
        Long id = service.register(movieTheaterDTO);

        URI uri = uriComponentsBuilder.path("/theater/{id}").buildAndExpand(id).toUri();

        return created(uri).build();
    }
}
