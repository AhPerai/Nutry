package com.example.projetonutri.Model;

public class Vitamina {

    private int id_vitamina;
    private String nome;

    public Vitamina(int id_vitamina, String nome) {
        this.id_vitamina = id_vitamina;
        this.nome = nome;
    }

    public int getId_vitamina() {
        return id_vitamina;
    }

    public void setId_vitamina(int id_vitamina) {
        this.id_vitamina = id_vitamina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
