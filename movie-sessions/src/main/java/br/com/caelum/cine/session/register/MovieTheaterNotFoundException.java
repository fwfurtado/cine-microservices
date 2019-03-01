package br.com.caelum.cine.session.register;

class MovieTheaterNotFoundException extends IllegalArgumentException {

   MovieTheaterNotFoundException(String message) {
        super(message);
    }
}
