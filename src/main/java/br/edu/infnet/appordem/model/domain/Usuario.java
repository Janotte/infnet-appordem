package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.interfaces.IPrinter;

import javax.persistence.*;

@Entity
public class Usuario implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    public Usuario() {
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

    public void setNome(String nome) throws CampoObrigatorioException {
        if(nome.isBlank()) throw new CampoObrigatorioException("O nome é necessário");
        this.nome = nome;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) throws CampoObrigatorioException {
        if(email.isBlank()) throw new CampoObrigatorioException("O e-mail é necessário");
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws CampoObrigatorioException {
        if(senha.isBlank()) throw new CampoObrigatorioException("A senha é necessária");
        this.senha = senha;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + email + ";" + senha;
    }
}
