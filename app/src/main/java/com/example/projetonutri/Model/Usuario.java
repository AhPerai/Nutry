package com.example.projetonutri.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {

    private static int id;
    private String nome;
    private String email;
    private String senha;
    private String idade;
    private String genero;
    private ArrayList<Refeicao> refeicoes = new ArrayList<>();
    Refeicao refeicao = new Refeicao();
    private ArrayList<Agua> aguas = new ArrayList<Agua>();

    public Usuario(){
    }

    public Usuario(String nome, String email, String senha, String idade, String genero) {
        geraId();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.genero = genero;
    }

    private void geraId() {
        id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void populaRefeicao(Date data){
        Refeicao refeicaoAux = new Refeicao();
        for(int i = 0; i < refeicao.getRefeicoes().size(); i++){
            refeicaoAux.getRefeicoes().add(refeicao.getRefeicoes().get(i));
        }
        refeicaoAux.setDataeHora(data);
        refeicoes.add(refeicaoAux);
        refeicao = new Refeicao();
    }

    public void setAlimentodaRefeicao(Alimento alimento) {
        refeicao.setRefeicoes(alimento);
    }

    public Refeicao getAlimentodaRefeicao() {
        return refeicao;
    }

    public void setAgua(Agua agua) {
        aguas.add(agua);
    }

    public ArrayList<Agua> getAguas() {
        return aguas;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + id + "Nome:"+ nome + "Idade: "+ idade + "Genero: "+ genero + "Email:"+ email + "Senha: "+ senha;
    }
}