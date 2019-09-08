package com.example.okhttpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);

        OkHttpClient client = new OkHttpClient();

        String link = "https://jsonplaceholder.typicode.com/posts";

        final Request request = new Request.Builder().url(link).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                textViewResult.setText("Code: "+e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful())
                {

                    final String myResponse = response.body().string();
                    Gson gson = new Gson();
                    Type postType = new TypeToken<ArrayList<Post>>(){}.getType();
                    final ArrayList<Post> posts = gson.fromJson(myResponse,postType);
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewResult.setText(posts.get(0).getText());
                        }
                    });
                }
            }
        });
    }
}
