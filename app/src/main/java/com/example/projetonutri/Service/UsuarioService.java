package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService {

    @FormUrlEncoded
    @POST("usuario")
    Call<Usuario> createUsuario(
            @Field("email") String email,
            @Field("senha") String senha,
            @Field("nome") String nome,
            @Field("idade") int idade,
            @Field("genero") String genero
    );


    @GET("usuario/{id}")
    Call<Usuario> getUsuarioById(@Path("id") int id);

    @GET("usuario")
    Call<List<Usuario>> getUsuarios();

    @FormUrlEncoded
    @PUT("usuario/{id}")
    Call<Usuario>
    updateUsuario(@Path("id") String id,
                  @Field("email") String email,
                  @Field("senha") String senha,
                  @Field("nome") String nome,
                  @Field("idade") int idade,
                  @Field("genero") String genero
    );

    @DELETE("usuario/{id}")
    Call<Usuario> deleteUsuarioById(@Path("id") int id);

    @FormUrlEncoded
    @POST("usuario/login")
    Call<Usuario> verificarLogin(
            @Field("email") String email,
            @Field("senha") String senha
    );

    @GET("usuario/refeicao/{id}")
    Call<List<Refeicao>> getRefeicaofromUsuario(@Path("id") int id);

}
