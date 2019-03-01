package br.com.caelum.cine.movies.exhibition;

import br.com.caelum.cine.movies.MovieNotFoundException;
import br.com.caelum.cine.movies.shared.Movie;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;

@Service
class ExhibitionMovieService {

    private ExhibitionMovieRepository repository;

    ExhibitionMovieService(ExhibitionMovieRepository repository) {
        this.repository = repository;
    }


    void onDisplay(Long id) {
        updateMovieByAndSet(id, Movie::onExhibition);
    }

    void outDisplay(Long id) {
        updateMovieByAndSet(id, Movie::outExhibition);
    }

    private void updateMovieByAndSet(Long id, Consumer<Movie> setOperation) {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));

        setOperation.accept(movie);

        repository.save(movie);
    }

}
