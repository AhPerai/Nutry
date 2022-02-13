package com.example.projetonutri.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    @SerializedName("id_usuario")
    private  int id;
    private String email;
    private String senha;
    private String nome;
    private int idade;
    private String genero;
    @SerializedName("refeicaos")
    private List<Refeicao> listaRefeicao;
    //    private ArrayList<Agua> listaAgua;

    public Usuario(String nome, String email, String senha,
                   int idade, String genero, List<Refeicao> listaRefeicao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.genero = genero;
        this.listaRefeicao = listaRefeicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Refeicao> getListaRefeicao() {
        return (ArrayList<Refeicao>) listaRefeicao;
    }

    public void setListaRefeicao(List<Refeicao> listaRefeicao) {
        this.listaRefeicao = listaRefeicao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", genero='" + genero + '\'' +
                '}';
    }
}
