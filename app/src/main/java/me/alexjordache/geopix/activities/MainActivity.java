package me.alexjordache.geopix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import me.alexjordache.geopix.R;
import me.alexjordache.geopix.utils.constants;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

     String userid;
     String username;
     String userStickerScore;
     String foundStickerScore;


    private final OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String userName = userNameView.getText().toString();
//        Integer stickersCollection = Integer.parseInt(stickerCollectionView.getText().toString());
//        Integer stickersFound = Integer.parseInt(stickersFoundView.getText().toString());

        setContentView(R.layout.activity_main);
        System.out.println("hi");
        while (constants.token == null) {}

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "=");
        Request request = new Request.Builder()
                .url("http://geopix.azurewebsites.net/api/me")
                .get()
                .addHeader("x-access-token", "helloo")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "0b9d4648-79c6-7d4c-35a0-11ce51516939")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }
                String jsonstr = response.body().string();
                System.out.println(jsonstr);
                JSONObject jsonResponse;

                try {

                    jsonResponse = new JSONObject(jsonstr);
                    //JSONObject usernameJson = jsonResponse.getJSONObject("username");
                    //JSONObject userStickerScoreJson = jsonResponse.getJSONObject("userStickerScore");
                    //JSONObject foundStickerScoreJson = jsonResponse.getJSONObject("foundStickerScore");
                     userid = jsonResponse.getString("_id");
                     username = jsonResponse.getString("username");
                     userStickerScore = "10";
                     foundStickerScore = "20";
                    System.out.println(username);
                    System.out.println(userStickerScore);
                    System.out.println(foundStickerScore);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });
        TextView userNameView = (TextView)findViewById(R.id.main_userName);
        TextView stickerCollectionView = (TextView)findViewById(R.id.yourSticker);
        TextView stickersFoundView = (TextView)findViewById(R.id.stickersFound);
        userNameView.setText("alex");
        stickerCollectionView.setText("32");
        stickersFoundView.setText("45");
        constants.userid = userid;
        constants.username = username;
        constants.userStickerScore = 44;
        constants.foundStickerScore = 55;

    }

    public void goToNFC(View view) {





        Intent intent = new Intent(this, WriteNFC.class);
        startActivity(intent);

    }
}
