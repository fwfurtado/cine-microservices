package br.com.caelum.cine.session.query;

import br.com.caelum.cine.session.shared.MovieSession;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

interface QueryMovieSessionRepository extends Repository<MovieSession, Long> {

    @Query("select s from MovieSession  s")
    List<SessionView> listPretty();
}
