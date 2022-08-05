package br.edu.infnet.appordem.model.domain;

public class Usuario extends Pessoa {

    private String senha;
    private Funcao funcao;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                super.toString() + '\'' +
                "senha='" + senha + '\'' +
                ", funcao=" + funcao +
                '}';
    }
}
