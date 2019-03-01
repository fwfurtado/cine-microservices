package br.com.caelum.cine.session.register;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import br.com.caelum.cine.session.configuration.MovieTheaterConfigurationProperties;
import br.com.caelum.cine.session.shared.MovieTheater;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Service
class MovieTheaterRepository {

    private RestTemplate restTemplate;
    private MovieTheaterConfigurationProperties movieTheaterConfiguration;

    MovieTheaterRepository(RestTemplate restTemplate, MovieTheaterConfigurationProperties movieTheaterConfiguration) {
        this.restTemplate = restTemplate;
        this.movieTheaterConfiguration = movieTheaterConfiguration;
    }

    @PostConstruct
    void postLoad() {
        restTemplate.setErrorHandler(new ErrorHandler());
    }

    MovieTheater findById(Long movieTheaterId) {
        return restTemplate.getForObject(movieTheaterConfiguration.getShowUrl(), MovieTheater.class, movieTheaterId);
    }

    private class ErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return response.getStatusCode().equals(NOT_FOUND);
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            throw new MovieTheaterNotFoundException("Cannot find movie theater");
        }
    }
}
