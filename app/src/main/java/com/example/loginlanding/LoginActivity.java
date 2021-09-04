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

    private ArrayList<String> usernames = new ArrayList<String>();

    private ArrayList<String> passwords = new ArrayList<String>();

    private Button loginButton;

    private EditText editText_username;

    private EditText editText_password;

    private TextView errMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create list of valid usernames
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

        // create valid passwords that pair with usernames using their index number
        for (int i = 1; i < 11; i++) {
            passwords.add(String.format("pass%d", i));
        }

        Log.d(ACTIVITY_LABEL, "passwords: " + passwords);

        loginButton = findViewById(R.id.login_button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_username = findViewById(R.id.login_editText_username);
                editText_password = findViewById(R.id.login_editText_password);

                String username = editText_username.getText().toString();
                String password = editText_password.getText().toString();

                editText_username.setBackgroundColor(Color.TRANSPARENT);
                editText_password.setBackgroundColor(Color.TRANSPARENT);

//                Log.d(ACTIVITY_LABEL, "username: " + username);
//                Log.d(ACTIVITY_LABEL, "pass: " + password);

                if (checkUsername(username)) {
                    int index = usernames.indexOf(username);

                    if (checkPassword(index, password)) {
                        // success, change activity to main
                        // send index num of user and username to main
                        nextActivity(index);

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

    public Boolean checkUsername(String username) {
        return usernames.contains(username);
    }

    public Boolean checkPassword(int userIndex, String password) {
        return password.equals(passwords.get(userIndex));
    }

    public void nextActivity(int userId) {
        Log.d(ACTIVITY_LABEL, "nextActivity> userId: " + userId);

        Intent intent = MainActivity.getIntent(getApplicationContext(), userId);

        startActivity(intent);
    }
}