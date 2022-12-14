package br.edu.infnet.appordem.model.domain;

import br.edu.infnet.appordem.model.exceptions.LicencaSemFabricanteException;
import br.edu.infnet.appordem.model.exceptions.ValorNegativoException;
import br.edu.infnet.appordem.model.exceptions.ValorVendaInvalidoException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCAS")
public class Licenca extends Produto {

    @Column(name = "quantidade_dispositivos", nullable = false)
    private int quantidadeDispositivos;

    @Column(name = "validade", length = 60, nullable = false)
    private String validade;

    @Column(name = "fabricante", length = 60)
    private String fabricante;

    public int getQuantidadeDispositivos() {
        return quantidadeDispositivos;
    }

    public void setQuantidadeDispositivos(int quantidadeDispositivos) {
        this.quantidadeDispositivos = quantidadeDispositivos;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) throws LicencaSemFabricanteException {

        if (fabricante == null)
            throw new LicencaSemFabricanteException("O campo fabricante não deve ser nulo!");

        if (fabricante.isEmpty())
            throw new LicencaSemFabricanteException("O campo fabricante deve ser preenchido!");

        this.fabricante = fabricante;
    }

    @Override
    public double calcularPrecoVenda() throws ValorVendaInvalidoException {

        if (getCustoCompra() < 0)
            throw new ValorNegativoException("O custo de compra da licença não pode ser negativo.");

        Double valor = getCustoCompra() * 2;

        if (valor < 2)
            throw new ValorVendaInvalidoException("O valor de venda da licença não pode ser menor que 2.00.");

        return valor;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + "; " + quantidadeDispositivos + "; " + validade + "; " + fabricante;
    }

}