package me.alexjordache.geopix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import me.alexjordache.geopix.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToNFC(View view) {

        TextView userNameView = (TextView)findViewById(R.id.main_userName);
        TextView stickerCollectionView = (TextView)findViewById(R.id.yourSticker);
        TextView stickersFoundView = (TextView)findViewById(R.id.stickersFound);

        String userName = userNameView.getText().toString();
        Integer stickersCollection = Integer.parseInt(stickerCollectionView.getText().toString());
        Integer stickersFound = Integer.parseInt(stickersFoundView.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
