package com.example.projetonutri.Model;

import java.util.ArrayList;
import java.util.Date;

public class Refeicao {

    private ArrayList<Alimento> refeicoes = new ArrayList<>();
    private Date dataeHora;

    public Refeicao() {
    }

    public ArrayList<Alimento> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(Alimento alimento) {
        refeicoes.add(alimento);
    }

    public Date getDataeHora() {
        return dataeHora;
    }

    public void setDataeHora(Date dataeHora) {
        this.dataeHora = dataeHora;
    }

    @Override
    public String toString() {
        return refeicoes + "";
    }
}
