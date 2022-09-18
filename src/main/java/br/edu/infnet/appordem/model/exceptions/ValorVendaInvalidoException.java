package br.edu.infnet.appordem.model.exceptions;

public class ValorVendaInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValorVendaInvalidoException(String message) {
        super(message);
    }
}
