package br.com.caelum.cine.session.register;

class MovieNotFoundException extends  IllegalArgumentException {


    MovieNotFoundException(String message) {
        super(message);
    }

}
