package br.edu.infnet.appordem.model.exceptions;

public class LicencaSemFabricanteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LicencaSemFabricanteException(String message) {
        super(message);
    }
}
