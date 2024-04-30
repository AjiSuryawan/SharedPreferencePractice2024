package com.example.sharedpreferencepractice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                // Get the SharedPreferences object
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

                // Retrieve the saved data
                String username = settings.getString("username", "No Username Found");

                if (username.equalsIgnoreCase("No Username Found")){
                    // intent ke login
                    Intent intent = new Intent(SplashScreen.this , MainActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    // intent ke home
                    Intent intent = new Intent(SplashScreen.this , HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);


    }
}