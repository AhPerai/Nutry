package com.example.projetonutri.Model;

import java.util.ArrayList;

public class Alimento {

    private int id_alimento;
    private String nome;
    private int categoriaID;
    private ArrayList<Vitamina> listaVitamina;

    public Alimento(int id_alimento, String nome, int categoria) {
        this.id_alimento = id_alimento;
        this.nome = nome;
        this.categoriaID = categoria;
    }

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return categoriaID;
    }

    public void setCategoria(int categoria) {
        this.categoriaID = categoria;
    }
}
