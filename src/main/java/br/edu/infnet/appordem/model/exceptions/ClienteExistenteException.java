package br.edu.infnet.appordem.model.exceptions;

public class ClienteExistenteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClienteExistenteException(String message) {
        super(message);
    }
}
