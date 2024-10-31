package com.example.loschanchosapp;

import com.example.loschanchosapp.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsuarioApi {

    @POST("api/usuario/cadastro")
    Call<Usuario> cadastrarUsuario(@Body Usuario usuario);

    @GET("api/usuario/{id}")
    Call<Usuario> obterUsuario(@Path("id") Long id);

    @GET("api/usuario")
    Call<List<Usuario>> listarUsuarios();

}
