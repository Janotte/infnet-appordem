package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.interfaces.IPrinter;

public class Cliente implements IPrinter {

    private Long codigo;
    private String nome;
    private String cpfCnpj;
    private String celular;
    private String email;

    public Cliente(Long codigo, String nome, String cpfCnpj, String celular, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.celular = celular;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + cpfCnpj + ";" + celular + ";" + email;
    }
}
