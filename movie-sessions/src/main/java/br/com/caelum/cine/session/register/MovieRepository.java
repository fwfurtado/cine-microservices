package br.com.caelum.cine.session.register;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import br.com.caelum.cine.session.ServerUnavailableException;
import br.com.caelum.cine.session.configuration.MovieConfigurationProperties;
import br.com.caelum.cine.session.shared.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Service
class MovieRepository {

    private RestTemplate restTemplate;
    private MovieConfigurationProperties movieConfiguration;

    MovieRepository(RestTemplate restTemplate, MovieConfigurationProperties movieConfiguration) {
        this.restTemplate = restTemplate;
        this.movieConfiguration = movieConfiguration;
    }

    @PostConstruct
    void postLoad() {
        restTemplate.setErrorHandler(new ErrorHandler());
    }

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    Movie findById(Long movieId) {
        return restTemplate.getForObject(movieConfiguration.getShowUrl(), Movie.class, movieId);
    }

    Movie findByIdFallback(Long movieId) {
        throw new ServerUnavailableException("Movie service unavailable");
    }

    private class ErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return response.getStatusCode().equals(NOT_FOUND);
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            throw new MovieNotFoundException("Cannot find movie");
        }

    }
}
