package com.example.projetonutri.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Refeicao {
    @SerializedName("id_refeicao")
    private  int id;
    @SerializedName("data")
    private Date data;
    @SerializedName("UsuarioIdUsuario")
    private int usuarioID;
    private ArrayList<Alimento> listaAlimento;

    public Refeicao(int id, Date data, int usuarioID, ArrayList<Alimento> listaAlimento) {
        this.id = id;
        this.data = data;
        this.usuarioID = usuarioID;
        this.listaAlimento = listaAlimento;
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

    public ArrayList<Alimento> getListaAlimento() {
        return listaAlimento;
    }

    public void setListaAlimento(ArrayList<Alimento> listaAlimento) {
        this.listaAlimento = listaAlimento;
    }
}
