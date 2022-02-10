package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Vitamina;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VitaminaService {

    @GET("alimento/{id}")
    Call<Vitamina> getVitaminaById(@Path("id") int id);

    @GET("alimento")
    Call<List<Vitamina>> getVitaminas();
}
