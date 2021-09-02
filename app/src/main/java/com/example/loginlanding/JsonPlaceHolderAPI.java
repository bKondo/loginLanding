package com.example.loginlanding;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

    @GET("posts")
    Call<List<Post>> getAnyPosts();

    @GET("posts/{int id}")
    Call<List<Post>> getUserPosts();
}
