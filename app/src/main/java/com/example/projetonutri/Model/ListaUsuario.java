package com.example.projetonutri.Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListaUsuario {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioLogado;

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + usuarios;
    }
}
