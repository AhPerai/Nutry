package com.example.projetonutri.Model;

import java.util.ArrayList;

public class Alimento {

    private static int id;
    private String nome;
    private ArrayList<Vitamina> vitamina;

    public Alimento(String nome, ArrayList<Vitamina> vitamina) {
        geraId();
        this.nome = nome;
        this.vitamina = vitamina;
    }

    private void geraId() {
        id++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Vitamina> getVitamina() {
        return vitamina;
    }

    public void setVitamina(ArrayList<Vitamina> vitamina) {
        this.vitamina = vitamina;
    }

    @Override
    public String toString() {
        return nome;
    }
}
