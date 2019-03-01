package br.com.caelum.cine.movies.query;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class QueryMovieService {

    private QueryMovieRepository repository;

    QueryMovieService(QueryMovieRepository repository) {
        this.repository = repository;
    }

    Optional<MovieView> findMovieBy(Long id) {

        return repository.findById(id);

    }
}
