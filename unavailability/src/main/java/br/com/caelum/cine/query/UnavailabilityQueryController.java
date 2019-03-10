package br.com.caelum.cine.query;

import static org.springframework.http.ResponseEntity.ok;

import java.time.ZonedDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UnavailabilityQueryController {

    private final UnavailabilityQueryService service;

    public UnavailabilityQueryController(UnavailabilityQueryService service) {
        this.service = service;
    }

    @GetMapping("{theaterId}")
    ResponseEntity<?> hasUnavailability(@PathVariable Long theaterId,
        @RequestParam(name = "startDate") String startDate,
        @RequestParam(name = "endDate") String endDate) {

        if (service.isAvailable(theaterId, ZonedDateTime.parse(startDate), ZonedDateTime.parse(endDate))) {
            return ok().build();
        }

        return ResponseEntity.badRequest().build();

    }
}
