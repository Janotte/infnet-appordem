package br.edu.infnet.appordem.model.domain;

public class Cliente extends Pessoa {

    private TipoCliente tipoCliente;

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                "tipoCliente=" + tipoCliente +
                '}';
    }
}
