package com.example.loginlanding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import android.util.Log;

public class LoginActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "LOGIN_ACTIVITY";

    private ArrayList<String> usernames = new ArrayList<>();

    private ArrayList<String> passwords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        usernames.add("Bret");
        usernames.add("Antonette");
        usernames.add("Samantha");
        usernames.add("Karianne");
        usernames.add("Kamren");
        usernames.add("Leopoldo");
        usernames.add("Elwyn");
        usernames.add("Maxime");
        usernames.add("Delphine");
        usernames.add("Moriah");

        Log.d(ACTIVITY_LABEL, "usernames: " + usernames);

        for (int i = 1; i < 11; i++) {
            passwords.add(String.format("pass%d",i));
        }

        Log.d(ACTIVITY_LABEL, "passwords: " + passwords);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}