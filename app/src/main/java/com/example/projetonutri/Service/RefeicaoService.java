package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Usuario;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RefeicaoService {

    @FormUrlEncoded
    @POST("refeicao")
    Call<Usuario> createRefeicao(
            @Field("data") Date data,
            @Field("UsuarioIdUsuario") int id
    );

    //id
    //data
    //Id_Usuario
    //Lista_alimentos

    //Lista de alimentos em arrayList
    //Id Refeicao e o Id de cada alimento
}
