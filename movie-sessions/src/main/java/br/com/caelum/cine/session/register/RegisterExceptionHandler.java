package br.com.caelum.cine.session.register;

import static org.springframework.http.ResponseEntity.notFound;

import br.com.caelum.cine.session.register.QueryMovieRepository.MovieNotFoundException;
import br.com.caelum.cine.session.register.QueryMovieTheaterRepository.MovieTheaterNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RegisterExceptionHandler {

    @ExceptionHandler({MovieNotFoundException.class, MovieTheaterNotFoundException.class})
    ResponseEntity<?> movieNotFound() {
        return notFound().build();
    }

}
