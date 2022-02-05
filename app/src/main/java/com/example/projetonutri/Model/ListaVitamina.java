package com.example.projetonutri.Model;

import java.util.ArrayList;

public class ListaVitamina {

    public static ArrayList<Vitamina> vitaminas = new ArrayList<>();

    public ListaVitamina(){
        vitaminas.add(new Vitamina("A"));
        vitaminas.add(new Vitamina("B1"));
        vitaminas.add(new Vitamina("B2"));
        vitaminas.add(new Vitamina("B3"));
        vitaminas.add(new Vitamina("B5"));
        vitaminas.add(new Vitamina("B6"));
        vitaminas.add(new Vitamina("B8"));
        vitaminas.add(new Vitamina("B9"));
        vitaminas.add(new Vitamina("B12"));
        vitaminas.add(new Vitamina("C"));
        vitaminas.add(new Vitamina("D"));
        vitaminas.add(new Vitamina("E"));
        vitaminas.add(new Vitamina("K"));
    }

    public static ArrayList<Vitamina> getVitaminas() {
        return vitaminas;
    }

    public static void setVitaminas(ArrayList<Vitamina> vitaminas) {
        ListaVitamina.vitaminas = vitaminas;
    }
}
