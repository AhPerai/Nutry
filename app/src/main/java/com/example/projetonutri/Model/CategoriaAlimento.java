package com.example.projetonutri.Model;

import java.util.ArrayList;

public class CategoriaAlimento {

    private String nomeCategoria;
    private ArrayList<Alimento> alimentos;

    public CategoriaAlimento() {
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public String toString() {
        return nomeCategoria ;
    }
}
