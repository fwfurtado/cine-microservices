package br.com.caelum.cine.theater.register;

import br.com.caelum.cine.theater.shared.MovieTheater;
import org.springframework.data.repository.Repository;

interface RegisterMovieTheaterRepository extends Repository<MovieTheater, Long> {

    void save(MovieTheater movieTheater);
}
