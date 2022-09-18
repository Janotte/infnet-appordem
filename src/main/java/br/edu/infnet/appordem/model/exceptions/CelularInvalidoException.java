package br.edu.infnet.appordem.model.exceptions;

public class CelularInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CelularInvalidoException(String message) {
        super(message);
    }
}
