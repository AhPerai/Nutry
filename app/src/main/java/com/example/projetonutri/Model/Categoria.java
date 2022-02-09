package com.example.projetonutri.Model;

import java.util.ArrayList;

public class Categoria {

    int id_categoria;
    private String nome;
    private ArrayList<Alimento> alimentos;

    public Categoria() {
    }

    public int getId() {
        return id_categoria;
    }

    public void setId(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public String toString() {
        return nome ;
    }
}
