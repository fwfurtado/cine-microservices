package br.com.caelum.cine.theater.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MovieTheaterType type;
    private Integer seatsNumber;

    /**
     * @deprecated frameworks eyes
     */
    @Deprecated
    MovieTheater() { }

    public MovieTheater(String name, MovieTheaterType type, Integer seatsNumber) {
        this.name = name;
        this.type = type;
        this.seatsNumber = seatsNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MovieTheaterType getType() {
        return type;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }
}
