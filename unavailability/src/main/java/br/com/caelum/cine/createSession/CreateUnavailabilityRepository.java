package br.com.caelum.cine.createSession;

import br.com.caelum.cine.shared.Unavailability;
import org.springframework.data.repository.Repository;

interface CreateUnavailabilityRepository extends Repository<Unavailability, Long> {

    void save(Unavailability unavailability);
}
