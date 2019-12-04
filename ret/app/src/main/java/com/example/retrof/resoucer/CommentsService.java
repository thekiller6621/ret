package com.example.retrof.resoucer;
//////////////////////////
import com.example.retrof.representacao.Comments;
import com.example.retrof.representacao.Comments;

import java.util.List;
//////////////////////////
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
///////////////////////////
public interface CommentsService {
        ///////////////////envia post para o servidor
        @POST("commments")
        Call<Comments> post(@Body Comments post);
        ///////////////////recupera post
        @GET("commments/{id}")
        Call<Comments>get(@Path("id") Integer id);
        ///////////////////tras listas
        @GET("commments")
        Call<List<Comments>> get();
        ///////////////////atualiza tudo
        @PUT("commments/{id}")
        Call<Comments> put(@Path("id") Integer id, @Body Comments posts);
        ///////////////////atualizar parcialmente
        @PATCH("commments/{id}")
        Call<Comments> patch(@Path("id") Integer id, @Body Comments posts);
        ///////////////////apagar
        @DELETE("commments/{id}")
        Call<Void>delete(@Path("id") Integer id);
        ///////////////////////







}
