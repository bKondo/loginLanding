package com.example.loginlanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "LOGIN_ACTIVITY";

    private ArrayList<String> usernames = new ArrayList<>();

    private ArrayList<String> passwords = new ArrayList<>();

    private Button loginButton;

    private EditText editText_username;

    private EditText editText_password;

    private TextView errMsg;

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

//        Log.d(ACTIVITY_LABEL, "usernames: " + usernames);

        for (int i = 1; i < 11; i++) {
            passwords.add(String.format("pass%d", i));
        }

//        Log.d(ACTIVITY_LABEL, "passwords: " + passwords);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_username = findViewById(R.id.login_editText_username);

                editText_password = findViewById(R.id.login_editText_password);

                String username = editText_username.getText().toString();

                String password = editText_password.getText().toString();

                editText_username.setHighlightColor(Color.TRANSPARENT);

                editText_password.setHighlightColor(Color.TRANSPARENT);

//                Log.d(ACTIVITY_LABEL, "username: " + username);

//                Log.d(ACTIVITY_LABEL, "pass: " + password);

                if (usernames.contains(username)) {
                    int index = usernames.indexOf(username);

                    if (password.equals(passwords.get(index))) {
                        // success, change activity to main
                        // send index num of user and username to main
                        nextActivity(this, index);

                    } else {
                        Toast.makeText(LoginActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
                        editText_password.setBackgroundColor(Color.RED);
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "incorrect username", Toast.LENGTH_LONG).show();
                    editText_username.setBackgroundColor(Color.RED);
                }
            }
        });
    }

    public void nextActivity(View view, int userId) {
        Intent intent = MainActivity.getIntent(getApplicationContext());

        intent.putExtra(LoginActivity.ACTIVITY_LABEL, userId);

        startActivity(intent);
    }
}