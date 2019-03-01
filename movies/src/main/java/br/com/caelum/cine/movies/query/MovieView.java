package br.com.caelum.cine.movies.query;

import org.springframework.beans.factory.annotation.Value;

interface MovieView {

    Long getId();

    String getName();

    @Value("#{target.active ? 'yes': 'no'}")
    String getActive();

    @Value("#{target.duration.toMinutes() + ' min' }")
    String getDuration();

}
