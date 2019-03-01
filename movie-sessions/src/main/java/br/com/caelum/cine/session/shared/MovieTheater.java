package br.com.caelum.cine.session.shared;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieTheater {

    @Column(name = "theaterId")
    private Long id;

    @Column(name = "theaterName")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
