package br.com.caelum.cine.session;

public class ServerUnavailableException extends RuntimeException {

    public ServerUnavailableException(String message) {
        super(message);
    }
}
