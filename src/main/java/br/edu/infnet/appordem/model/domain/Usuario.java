package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.interfaces.IPrinter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "senha", nullable = false, length = 60)
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha) {
        if (nome == null || nome.isBlank()) throw new CampoObrigatorioException("O nome é necessário.");
        if (email == null || email.isBlank()) throw new CampoObrigatorioException("O e-mail é necessário.");
        if (senha == null || senha.isBlank()) throw new CampoObrigatorioException("A senha é necessária.");
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha) {
        if (nome == null || nome.isBlank()) throw new CampoObrigatorioException("O nome é necessário.");
        if (email == null || email.isBlank()) throw new CampoObrigatorioException("O e-mail é necessário.");
        if (senha == null || senha.isBlank()) throw new CampoObrigatorioException("A senha é necessária.");
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Usuario {id: " + id + ", nome: " + nome + ", e-mail: " + email + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
