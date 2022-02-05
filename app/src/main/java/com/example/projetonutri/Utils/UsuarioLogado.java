package com.example.projetonutri.Utils;

import com.example.projetonutri.Model.Usuario;

public class UsuarioLogado{
    private Usuario usuario;
    private static UsuarioLogado instance;

    public static UsuarioLogado getInstance(){
        if(instance == null){
            instance = new UsuarioLogado();
        }

        return instance;
    }

    private UsuarioLogado() {
    }

    public Usuario getUsuarioLogado() {
        return usuario;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuario = usuario;
    }
}
