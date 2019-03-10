package br.com.caelum.cine.query;

import br.com.caelum.cine.shared.Unavailability;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

interface UnavailabilityQueryRepository extends Repository<Unavailability, Long> {

    @Query("select u from Unavailability u where u.theaterId = :theaterId and "
        + "(:startDate between u.startDate and u.endDate or "
        + ":endDate between u.startDate and u.endDate)")
    List<Unavailability> listOverlaps(@Param("theaterId") Long theaterId,@Param("startDate") ZonedDateTime startDate, @Param("endDate") ZonedDateTime endDate);

}
