package com.example.loschanchosapp;

import com.example.loschanchosapp.Doacao;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DoacaoApi {
    @POST("/api/doacao/criar/{userId}")
    Call<Doacao> criarDoacao(@Path("userId") Long userId, @Body Doacao doacao);
}
