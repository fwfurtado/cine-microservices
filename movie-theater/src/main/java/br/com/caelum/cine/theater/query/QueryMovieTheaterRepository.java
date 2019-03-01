package br.com.caelum.cine.theater.query;

import br.com.caelum.cine.theater.shared.MovieTheater;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface QueryMovieTheaterRepository extends Repository<MovieTheater, Long> {

    List<MovieTheaterView> findAll();

    Optional<MovieTheaterView> findById(Long id);
}
