package br.com.caelum.cine.theater.query;

import br.com.caelum.cine.theater.shared.MovieTheater;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

interface QueryMovieTheaterRepository extends Repository<MovieTheater, Long> {

    @Query("select t from MovieTheater t")
    List<MovieTheaterView> findAll();

    Optional<MovieTheaterView> findTheaterViewById(Long id);
}
