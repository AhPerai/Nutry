package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.Vitamina;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlimentoService {

    @GET("alimento/{id}")
    Call<Alimento> getAlimentoById(@Path("id") int id);

    @GET("alimento")
    Call<List<Alimento>> getAlimentos();

    @GET("alimento/vitamina/{id}")
    Call<List<Vitamina>> getVitaminasFromAlimento(@Path("id") int id);
}
