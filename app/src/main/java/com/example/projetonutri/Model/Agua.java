package com.example.projetonutri.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Agua {

    @SerializedName("id_agua")
    private  int id;
    @SerializedName("data")
    private Date data;
    @SerializedName("UsuarioIdUsuario")
    private int usuarioID;
    @SerializedName("quantidade")
    private int quantidade;

    public Agua(int id, Date data, int usuarioID, int quantidade) {
        this.id = id;
        this.data = data;
        this.usuarioID = usuarioID;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
