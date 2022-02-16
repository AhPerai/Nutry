package com.example.projetonutri.Service;

import com.example.projetonutri.Model.Agua;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    //Variável que guarda a instância do retrofit
    private final Retrofit retrofit;

    //Configuração básica do retrofit
    public RetrofitService() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.6:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Chamada aos demais Services
    public UsuarioService getUsuarioService() {
        return this.retrofit.create(UsuarioService.class);
    }

    public CategoriaService getCategoriaService() { return this.retrofit.create(CategoriaService.class); }

    public RefeicaoService getRefeicaoService() { return this.retrofit.create(RefeicaoService.class); }

    public AguaService getAguaService() { return this.retrofit.create(AguaService.class); }

    public AlimentoService getAlimentoService() { return this.retrofit.create(AlimentoService.class); }
}
