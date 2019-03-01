package br.com.caelum.cine.movies.query;

import org.springframework.beans.factory.annotation.Value;

interface MovieView {
    Long getId();
    String getName();
    boolean isActive();
    @Value("#{target.toMinutes()}")
    Long getDuration();
}
