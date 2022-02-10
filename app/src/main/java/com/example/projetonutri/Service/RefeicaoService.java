package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Refeicao_Alimento;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.Model.Vitamina;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RefeicaoService {

    @FormUrlEncoded
    @POST("refeicao")
    Call<Refeicao> createRefeicao(
            @Field("data") Date data,
            @Field("UsuarioIdUsuario") int id
    );

    @GET("refeicao/{id}")
    Call<Refeicao> getRefeicaoById(@Path("id") int id);

    @GET("refeicao")
    Call<List<Refeicao>> getRefeicoes();

    @GET("refeicao/vitamina/{id}")
    Call<List<Vitamina>> getVitaminasFromRefeicao(@Path("id") int id);

    @GET("refeicao/alimento/{id}")
    Call<List<Alimento>> getAlimentosFromRefeicao(@Path("id") int id);

    @FormUrlEncoded
    @POST("refeicao/alimento/relacao")
    Call<Refeicao_Alimento> relacionarRefeicaoAlimento(
            @Field("RefeicaoIdRefeicao") int id_refeicao,
            @Field("AlimentoIdAlimento") int id_alimento
    );

}
