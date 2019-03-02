package br.com.caelum.cine.session.shared;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieTheater {

    @Id
    private Long id;

    private String name;

    /**
     * @deprecated frameworks eyes
     */
    @Deprecated
    MovieTheater() { }

    public MovieTheater(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
