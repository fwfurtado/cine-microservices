package br.com.caelum.cine.createSession;

import java.time.ZonedDateTime;

class CreatedMovieSession {

    private Long theaterId;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public Long getTheaterId() {
        return theaterId;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }
}
