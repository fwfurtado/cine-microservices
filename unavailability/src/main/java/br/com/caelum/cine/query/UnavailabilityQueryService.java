package br.com.caelum.cine.query;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;

@Service
class UnavailabilityQueryService {

    private final UnavailabilityQueryRepository repository;

    UnavailabilityQueryService(UnavailabilityQueryRepository repository) {
        this.repository = repository;
    }

    boolean isAvailable(Long theaterId, ZonedDateTime startDate, ZonedDateTime endDate) {

        return repository.listOverlaps(theaterId, startDate, endDate).isEmpty();
    }
}
