package com.example.projetonutri.Model;

import java.util.Date;

public class Agua {

    private int quantidadeDeCopos;
    private Date dataEHora;

    public Agua(int quantidadeDeCopos, Date dataEHora) {
        this.quantidadeDeCopos = quantidadeDeCopos;
        this.dataEHora = dataEHora;
    }

    public int getQuantidadeDeCopos() {
        return quantidadeDeCopos;
    }

    public void setQuantidadeDeCopos(int quantidadeDeCopos) {
        this.quantidadeDeCopos = quantidadeDeCopos;
    }

    public Date getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(Date dataEHora) {
        this.dataEHora = dataEHora;
    }

    @Override
    public String toString() {
        return "Agua{" +
                "quantidadeDeCopos=" + quantidadeDeCopos +
                ", dataEHora=" + dataEHora +
                '}';
    }
}
