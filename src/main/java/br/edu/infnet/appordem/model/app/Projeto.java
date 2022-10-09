package br.edu.infnet.appordem.model.app;

import br.edu.infnet.appordem.interfaces.IPrinter;

import java.util.List;

public class Projeto implements IPrinter {

    private String nome;
    private String descricao;
    private String autor;
    private String disciplina;
    private List<Classe> classes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public void imprimir() {
        System.out.println("- " + nome + " | " + descricao+ " | " + autor+ " | " + disciplina);
        for (Classe c : classes) {
            c.imprimir();
        }
    }
}