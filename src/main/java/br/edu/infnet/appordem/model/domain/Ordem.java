package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.model.exceptions.ClienteNuloException;
import br.edu.infnet.appordem.interfaces.IPrinter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ORDENS")
public class Ordem implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "situacao")
    private Situacao situacao;

    @Column(name = "tipo_atendimento")
    private TipoAtendimento tipoAtendimento;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "equipamento", nullable = false)
    private String equipamento;

    @Column(name = "problema", nullable = false)
    private String problema;

    @Column(name = "solucao")
    private String solucao;

    @Column(name = "observacao")
    private String observacao;

    @ManyToMany(cascade = CascadeType.DETACH)
    private Set<Produto> produtos;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Ordem() {
    }

    public Ordem(Cliente cliente, Set<Produto> produtos) {
        if (cliente == null) throw new ClienteNuloException("Impossível criar uma Ordem sem um cliente!");
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordem ordem = (Ordem) o;
        return Objects.equals(id, ordem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "; " + data + "; " + cliente;
    }
}
