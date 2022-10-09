package br.edu.infnet.appordem.model.exceptions;

public class ServicoComGarantiaInvalidaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ServicoComGarantiaInvalidaException(String message) {
        super(message);
    }

}