package br.com.caelum.cine.session.register;

import br.com.caelum.cine.session.shared.MovieSession;
import org.springframework.data.repository.Repository;

interface RegisterRepository extends Repository<MovieSession, Long> {

    void save(MovieSession movieSession);
}
