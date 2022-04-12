package com.example.placeholder.network;

import com.example.placeholder.model.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceHolderApi {
    @GET("/comments/{id}")
    public Call<Comments> getCommentWithID(@Path("id") int id);

    @GET("/comments")
    public Call<List<Comments>> getAllComments();

    @GET("/comments")
    public Call<List<Comments>> getCommentOfPost(@Query("postId") int id);

    @POST("/comments")
    public Call<Comments> commentData(@Body Comments data);
}
