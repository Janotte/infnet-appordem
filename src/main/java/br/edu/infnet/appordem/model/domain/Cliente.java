package br.edu.infnet.appordem.model.domain;

public class Cliente {

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

    public void impressao() {
        System.out.println("# Cliente");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + cpfCnpj + ";" + celular + ";" + email;
    }
}
