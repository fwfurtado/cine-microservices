package br.com.caelum.cine.theater.register;

import java.util.StringJoiner;

public class CreatedMovieTheater {

    private Long id;
    private String name;

    /**
     * @deprecated frameworks eyes
     */
    @Deprecated
    CreatedMovieTheater() { }

    public CreatedMovieTheater(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreatedMovieTheater.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .toString();
    }
}
