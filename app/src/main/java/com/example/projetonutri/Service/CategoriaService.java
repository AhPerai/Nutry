package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoriaService {

    @GET("categoria/{id}")
    Call<Categoria> getCategoriaById(@Path("id") int id);

    @GET("categoria")
    Call<List<Categoria>> getCategorias();

    @GET("categoria/alimento/{id}")
    Call<List<Alimento>> getAlimentosFromCategoria(@Path("id") int id);
}
