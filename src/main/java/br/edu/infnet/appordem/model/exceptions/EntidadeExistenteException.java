package br.edu.infnet.appordem.model.exceptions;

public class EntidadeExistenteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntidadeExistenteException(String message) {
        super(message);
    }
}