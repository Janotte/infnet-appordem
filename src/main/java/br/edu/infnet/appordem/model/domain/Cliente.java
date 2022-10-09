package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.exceptions.CelularInvalidoException;
import br.edu.infnet.appordem.model.exceptions.CpfCnpjInvalidoException;
import br.edu.infnet.appordem.interfaces.IPrinter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CLIENTES")
public class Cliente implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "cpf_cnpj", length = 20)
    private String cpfCnpj;

    @Column(name = "celular", length = 15)
    private String celular;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Cliente(String nome, String cpfCnpj, String celular, String email) throws CampoObrigatorioException, CpfCnpjInvalidoException, CelularInvalidoException {
        if (nome == null || nome.isBlank()) throw new CampoObrigatorioException("O nome do cliente é necessário.");
        if (cpfCnpj == null || cpfCnpj.isBlank()) throw new CpfCnpjInvalidoException("Não é possível aceitar CPF nulo para cliente");
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.celular = celular;
        this.email = email;
    }

    public Cliente(Long id, String nome, String cpfCnpj, String celular, String email) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return id + "; " + nome + "; " + cpfCnpj + "; " + celular + "; " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
