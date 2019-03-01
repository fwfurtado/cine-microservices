package br.com.caelum.cine.theater.register;

import br.com.caelum.cine.theater.shared.MovieTheaterType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MovieTheaterDTO {

    @NotNull
    private MovieTheaterType type;

    @Min(10)
    private Integer seats;

    @NotBlank
    private String name;

    public void setType(MovieTheaterType type) {
        this.type = type;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MovieTheaterType getType() {
        return type;
    }

    public Integer getSeatsNumber() {
        return seats;
    }
}
