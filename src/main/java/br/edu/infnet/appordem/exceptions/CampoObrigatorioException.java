package br.edu.infnet.appordem.exceptions;

public class CampoObrigatorioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CampoObrigatorioException(String message) {
        super(message);
    }
}
