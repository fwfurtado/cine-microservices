package br.com.caelum.cine.session.createTheater;

import br.com.caelum.cine.session.shared.MovieTheater;
import org.springframework.data.repository.Repository;

interface CreateMovieTheaterRepository extends Repository<MovieTheater, Long> {

    boolean existsById(Long id);

    void save(MovieTheater movieTheater);
}
