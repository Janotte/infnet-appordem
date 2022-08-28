package br.edu.infnet.appordem.exceptions;

public class OrdemSemProdutoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OrdemSemProdutoException(String message) {
        super(message);
    }
}
