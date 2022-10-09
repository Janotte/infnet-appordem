package br.edu.infnet.appordem.model.exceptions;

public class ComponenteComNcmInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ComponenteComNcmInvalidoException(String message) {
        super(message);
    }
}