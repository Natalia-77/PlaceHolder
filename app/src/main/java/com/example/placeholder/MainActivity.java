package com.example.placeholder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.placeholder.model.Comments;
import com.example.placeholder.network.PlaceHolderNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvInfoComments);

        PlaceHolderNetwork.getInstance()
                .getJSONApi()
                .getCommentWithID(1)
                .enqueue(new Callback<Comments>() {
                    @Override
                    public void onResponse(@NonNull Call<Comments> call, @NonNull Response<Comments> response) {
                        Comments comments = response.body();
                        textView.setText(comments.getEmail());
                    }

                    @Override
                    public void onFailure(@NonNull Call<Comments> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}