package com.example.carbongo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;



public class LoginActivity extends AppCompatActivity {
    EditText emailET, passwordET;
    TextView authStatusTV;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore fstore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = findViewById(R.id.etEmail);
        passwordET = findViewById(R.id.etPassword);
        authStatusTV = findViewById(R.id.etStatus);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            authStatusTV.setText("onStart reloaded and " + currentUser.getEmail() + " is logged in");
            // Take any action needed here when screen loads and a user is logged in
        }
        else {
            authStatusTV.setText("onStart reloaded and user is null");
            // Take any action needed here when screen loads and a user is NOT logged in
        }
    }
    public void handleAuthChange(View v) {
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        if(v.getId()==R.id.loginButton)
            signIn(email, password);
        else if (v.getId()==R.id.signupButton) {
            signUp(email, password);
        }

    }
    public void signUp(String email, String password) {

        // If the email and password passed in are not null, then try to create a User
        if (email != null && password != null) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                authStatusTV.setText("Signed up " + user.getEmail() + " successfully");
                                Intent intent = new Intent(LoginActivity.this, InfoActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(LoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                authStatusTV.setText("Signed up - FAILED");
                            }
                        }
                    });
        }
    }
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("Denna", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            authStatusTV.setText("Signed in " + user.getEmail());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("Denna", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }






}