package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Agua;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Vitamina;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AguaService {

    @FormUrlEncoded
    @POST("agua")
    Call<Agua> createAgua(
            @Field("quantidade") int quantidade,
            @Field("UsuarioIdUsuario") int id
    );

    @GET("agua/{id}")
    Call<Agua> getAguaById(@Path("id") int id);

    @GET("agua")
    Call<List<Agua>> getAgua();
}
