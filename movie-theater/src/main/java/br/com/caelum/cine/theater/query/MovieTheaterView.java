package br.com.caelum.cine.theater.query;

import br.com.caelum.cine.theater.shared.MovieTheaterType;

interface MovieTheaterView {

    String getId();

    String getName();

    MovieTheaterType getType();

    Integer getSeatsNumber();
}
