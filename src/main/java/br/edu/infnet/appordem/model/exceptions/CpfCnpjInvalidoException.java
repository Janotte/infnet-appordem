package br.edu.infnet.appordem.model.exceptions;

public class CpfCnpjInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CpfCnpjInvalidoException(String message) {
        super(message);
    }
}
