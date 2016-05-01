package me.alexjordache.geopix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import me.alexjordache.geopix.R;

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

        EditText userNameField = (EditText)findViewById(R.id.initial_username);
        EditText passwordField = (EditText)findViewById(R.id.initial_password);

        String userName = userNameField.getText().toString();
        String password = passwordField.getText().toString();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
