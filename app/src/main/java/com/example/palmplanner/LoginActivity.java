package com.example.palmplanner;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton, createAccButton;

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Firebase authentication
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        //Initialize the views
        usernameEditText= findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        createAccButton= findViewById(R.id.createAccButton);
        loginButton = findViewById(R.id.loginButton);

        //click listeners for buttons
        createAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(username.isEmpty()|| password.isEmpty()){
            Toast.makeText(LoginActivity.this, "Fill in both username and password", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}
