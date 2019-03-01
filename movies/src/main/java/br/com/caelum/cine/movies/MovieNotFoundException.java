package br.com.caelum.cine.movies;

public class MovieNotFoundException extends IllegalArgumentException {

    private final Long id;

    public MovieNotFoundException(Long id) {
        super(String.format("Cannot find movie with '%s'", id));
        this.id = id;
    }

    Long getId() {
        return id;
    }
}
