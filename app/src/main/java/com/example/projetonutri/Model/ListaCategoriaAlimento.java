package com.example.projetonutri.Model;

import java.util.ArrayList;

public class ListaCategoriaAlimento {

    ArrayList<CategoriaAlimento> categoriaAlimentos = new ArrayList<>();

    public ListaCategoriaAlimento() {
        CategoriaAlimento categoriaAlimento = new CategoriaAlimento();
        categoriaAlimento.setNomeCategoria("Carboidratos");
        ArrayList<Alimento> alimentos = new ArrayList<>();
        ArrayList<Vitamina> vitaminas = new ArrayList<>();
        ListaVitamina listaVitamina = new ListaVitamina();
        for(int i = 0; i < listaVitamina.getVitaminas().size(); i++){
            Vitamina vitamina = listaVitamina.getVitaminas().get(i);
            if((vitamina.getNomeVitamina().equals("E")) || (vitamina.getNomeVitamina().equals("B8"))
                    || (vitamina.getNomeVitamina().equals("B9"))){
                vitaminas.add(vitamina);
            }
        }
        alimentos.add(new Alimento("Arroz", vitaminas));
        ArrayList<Vitamina> vitaminas2 = new ArrayList<>();
        for(int i = 0; i < listaVitamina.getVitaminas().size(); i++){
            Vitamina vitamina = listaVitamina.getVitaminas().get(i);
            if((vitamina.getNomeVitamina().equals("B6"))){
                vitaminas2.add(vitamina);
            }
        }
        alimentos.add(new Alimento("Macarrão", vitaminas2));

        ArrayList<Vitamina> vitaminas3 = new ArrayList<>();
        for(int i = 0; i < listaVitamina.getVitaminas().size(); i++){
            Vitamina vitamina = listaVitamina.getVitaminas().get(i);
            if((vitamina.getNomeVitamina().equals("B6"))){
                vitaminas3.add(vitamina);
            }
        }
        alimentos.add(new Alimento("Pão", vitaminas3));
        categoriaAlimento.setAlimentos(alimentos);

        categoriaAlimentos.add(categoriaAlimento);

        CategoriaAlimento categoriaAlimento2 = new CategoriaAlimento();
        categoriaAlimento2.setNomeCategoria("Proteína Animal");
        ArrayList<Alimento> alimentos2 = new ArrayList<>();
        ArrayList<Vitamina> vitaminas4 = new ArrayList<>();
        ListaVitamina listaVitamina2 = new ListaVitamina();
        for(int i = 0; i < listaVitamina2.getVitaminas().size(); i++){
            Vitamina vitamina = listaVitamina2.getVitaminas().get(i);
            if((vitamina.getNomeVitamina().equals("B3"))){
                vitaminas4.add(vitamina);
            }
        }
        alimentos2.add(new Alimento("Frango", vitaminas4));
        ArrayList<Vitamina> vitaminas5 = new ArrayList<>();
        for(int i = 0; i < listaVitamina.getVitaminas().size(); i++){
            Vitamina vitamina = listaVitamina.getVitaminas().get(i);
            if((vitamina.getNomeVitamina().equals("B6")) || (vitamina.getNomeVitamina().equals("B12"))){
                vitaminas5.add(vitamina);
            }
        }
        alimentos2.add(new Alimento("Carne Bovina", vitaminas5));

        ArrayList<Vitamina> vitaminas6 = new ArrayList<>();
        for(int i = 0; i < listaVitamina.getVitaminas().size(); i++){
            Vitamina vitamina = listaVitamina.getVitaminas().get(i);
            if((vitamina.getNomeVitamina().equals("B6"))){
                vitaminas6.add(vitamina);
            }
        }
        alimentos2.add(new Alimento("Carne Suína", vitaminas6));
        categoriaAlimento2.setAlimentos(alimentos2);

        categoriaAlimentos.add(categoriaAlimento2);
    }

    public ArrayList<CategoriaAlimento> getCategoriaAlimentos() {
        return categoriaAlimentos;
    }

    public void setCategoriaAlimentos(ArrayList<CategoriaAlimento> categoriaAlimentos) {
        this.categoriaAlimentos = categoriaAlimentos;
    }

    @Override
    public String toString() {
        return "ListaCategoriaAlimento{" +
                "categoriaAlimentos=" + categoriaAlimentos +
                '}';
    }
}
