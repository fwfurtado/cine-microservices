package br.com.caelum.cine.session.register;

import static org.springframework.http.ResponseEntity.notFound;

import br.com.caelum.cine.session.ServerUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RegisterExceptionHandler {

    @ExceptionHandler({MovieNotFoundException.class, MovieTheaterNotFoundException.class})
    ResponseEntity<?> movieNotFound() {
        return notFound().build();
    }


    @ExceptionHandler(ServerUnavailableException.class)
    ResponseEntity<?> serverUnavailable() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

}
