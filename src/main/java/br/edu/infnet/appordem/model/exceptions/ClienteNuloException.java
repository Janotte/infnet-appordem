package br.edu.infnet.appordem.model.exceptions;

public class ClienteNuloException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClienteNuloException(String message) {
        super(message);
    }
}