package br.com.caelum.cine.movies.register;

import java.time.Duration;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

class MovieDTO {

    @NotBlank
    private String name;

    @NotNull
    private Duration duration;

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
