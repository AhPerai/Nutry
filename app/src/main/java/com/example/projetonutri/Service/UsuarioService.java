package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService {

    @POST("usuario")
    Call<Usuario> createUsuario(@Body Usuario usuario);

    @GET("usuario/{id}")
    Call<Usuario> getUsuarioById(@Path("id") String id);

    @GET("usuario")
    Call<List<Usuario>> getUsuarios();

    @PUT("usuario")
    Call<Usuario> updateUsuario(@Body Usuario usuario);

    @DELETE("usuario/{id}")
    Call<Usuario> deleteUsuarioById(@Path("id") String id);

}
