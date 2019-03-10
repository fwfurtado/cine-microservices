package br.com.caelum.cine.session.configuration;

import br.com.caelum.cine.session.shared.MovieSession;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UnavailabilityClient {

    private static final String UNAVAILABILITY_BASE_URL = "http://unavailability/";

    private final RestTemplate restTemplate;

    public UnavailabilityClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "isAvailableFallback")
    public boolean isAvailable(MovieSession session) {
        URI uri = UriComponentsBuilder.fromUriString(UNAVAILABILITY_BASE_URL)
            .path("{theaterId}")
            .queryParam("startDate", session.getDate().format(DateTimeFormatter.ISO_INSTANT))
            .queryParam("endDate", session.getForecastOfEnd().format(DateTimeFormatter.ISO_INSTANT))
            .buildAndExpand(session.getMovieTheater().getId())
            .toUri();

        System.out.println("\n\n");
        System.out.println(uri);
        System.out.println("\n\n");

        try {
            restTemplate.getForEntity(uri, String.class);
            return true;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }


    public boolean isAvailableFallback(MovieSession session) {
        throw new UnavailableService();
    }
}
