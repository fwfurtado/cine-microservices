package br.com.caelum.cine.movies;

import static org.springframework.http.ResponseEntity.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = MovieExceptionHandler.class)
class MovieExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MovieExceptionHandler.class);

    @ExceptionHandler(MovieNotFoundException.class)
    ResponseEntity<?> movieNotFound(MovieNotFoundException e) {

        LOG.warn("Not found movie with id '{}', when trying to inactivate him.", e.getId());

        return notFound().build();
    }

}
