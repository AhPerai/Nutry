package com.example.projetonutri.Model;

public class Vitamina {

    private static int id;
    private String nomeVitamina;

    public Vitamina(String nomeVitamina){
        geraId();
        this.nomeVitamina = nomeVitamina;

    }

    public Vitamina() {
    }

    private void geraId() {
        id++;
    }

    public int getVitamina() {
        return id;
    }

    public void setVitamina(int vitamina) {
        this.id = vitamina;
    }

    public String getNomeVitamina() {
        return nomeVitamina;
    }

    public void setNomeVitamina(String nomeVitamina) {
        this.nomeVitamina = nomeVitamina;
    }

    @Override
    public String toString() {
        return "Vitamina{" +
                "nomeVitamina='" + nomeVitamina + '\'' +
                '}';
    }
}
