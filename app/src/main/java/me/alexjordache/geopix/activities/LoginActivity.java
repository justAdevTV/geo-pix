package me.alexjordache.geopix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;


import me.alexjordache.geopix.R;
import me.alexjordache.geopix.utils.constants;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Callback;


/**
 * Created by Alex on 4/30/2016.
 */
public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void doLogin(View view) {


        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    private final OkHttpClient client = new OkHttpClient();
    public void run() throws IOException {
        EditText userNameField = (EditText)findViewById(R.id.initial_username);
        EditText passwordField = (EditText)findViewById(R.id.initial_password);

        final String userName = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "username=" + userName + "&password=" + password + "&=");
        Request request = new Request.Builder()
                .url("http://geopix.azurewebsites.net/api/signup")
                .post(body)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "7d0fdc07-ec55-5a02-c423-7f16883351bf")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }
                constants.token = userName;
                System.out.println(response.body().string());

            }
        });
    }
}
