package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.interfaces.IPrinter;

public class Cliente implements IPrinter {

    private Long id;
    private String cpfCnpj;
    private String nome;
    private String celular;
    private String email;

    public Cliente(String nome, String cpfCnpj, String celular, String email) throws CampoObrigatorioException, CpfCnpjInvalidoException {

        if (nome == null) throw new CampoObrigatorioException("O nome do cliente é necessário.");

        if (nome.isBlank()) throw new CampoObrigatorioException("O nome do cliente é necessário.");

        if (cpfCnpj == null) throw new CpfCnpjInvalidoException("Não é possível aceitar CPF nulo para cliente");

        if (cpfCnpj.isBlank()) throw new CpfCnpjInvalidoException("O CPF ou CNPJ do cliente é necessário.");

        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.celular = celular;
        this.email = email;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + cpfCnpj + ";" + celular + ";" + email;
    }
}
