package com.example.projetonutri.Model;

import java.util.ArrayList;

public class Categoria {

    int id_categoria;
    private String nome;

    public Categoria(int id_categoria, String nome) {
        this.id_categoria = id_categoria;
        this.nome = nome;
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


    @Override
    public String toString() {
        return nome ;
    }
}
