package br.com.caelum.cine.session.register;

import static org.springframework.http.ResponseEntity.created;

import br.com.caelum.cine.session.MovieSessionController;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@MovieSessionController
class RegisterController {

    private RegisterService service;

    RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody MovieSessionDTO movieSessionDTO, ServletUriComponentsBuilder uriComponentsBuilder) {
        Long id = service.register(movieSessionDTO);

        URI uri = uriComponentsBuilder.path("/sessions/{id}").buildAndExpand(id).toUri();

        return created(uri).build();
    }
}
