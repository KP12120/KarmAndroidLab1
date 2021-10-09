package com.example.karmandroidlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "Waring Message");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "Waring Message");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "Waring Message");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "Waring Message");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, "Waring Message");
    }


    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w(TAG, "Message");
        Log.w("MainActivity", "In onCreate() - Loading Widgets");

        Button loginButton = findViewById(R.id.loginButton);
        EditText edittext = findViewById(R.id.editTextEmailAddress);
        loginButton.setOnClickListener(clk -> {
            String editTextEmailaddress = edittext.getText().toString();
             Intent nextPage = new Intent( MainActivity.this, Secondactivity.class);
             nextPage.putExtra( "EmailAddress", editTextEmailaddress );
             startActivity( nextPage);




        });

    }
}
