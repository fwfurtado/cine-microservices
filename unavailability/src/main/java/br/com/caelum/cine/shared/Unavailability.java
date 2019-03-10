package br.com.caelum.cine.shared;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Unavailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long theaterId;

    @NotNull
    private ZonedDateTime startDate;

    @NotNull
    private ZonedDateTime endDate;

    /**
     * @deprecated frameworks eyes
     */
    @Deprecated
    Unavailability() { }

    public Unavailability(Long theaterId, ZonedDateTime startDate, ZonedDateTime endDate) {

        this.theaterId = theaterId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }
}
